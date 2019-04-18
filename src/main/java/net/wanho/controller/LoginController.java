package net.wanho.controller;

import com.alibaba.fastjson.JSONObject;
import net.wanho.consts.ConstMsg;
import net.wanho.dto.EmployeeDto;
import net.wanho.dto.ListMenuDto;
import net.wanho.dto.LoginDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.exception.ServiceException;
import net.wanho.service.EmployeeServiceI;
import net.wanho.service.LoginServiceI;
import net.wanho.service.Position_Menu_RelationsServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2019/4/15.
 */
@RequestMapping("LoginServlet")
@Controller
public class LoginController {
    @Autowired
    private LoginServiceI loginServiceI;
    @Autowired
    private EmployeeServiceI employeeServiceI;
    @Autowired
    private Position_Menu_RelationsServiceI position_Menu_RelationsServiceI;

    @RequestMapping("/loginCheck")
    protected void loginCheck(HttpServletRequest request, HttpServletResponse response) {

        String employeeId = request.getParameter("employeeId");
        String password = request.getParameter("password");
        List<LoginDto> list = null;
        JSONObject jobj = new JSONObject();
        try {

            list = loginServiceI.getUser(employeeId, password);
            if (list != null && list.size() > 0) {
                // 登录验证成功
                EmployeeDto empStatus = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                if ("0".equals(empStatus.getStatus().trim())) {
                    jobj.put("status", 1);
                    jobj.put("msg", ConstMsg.LOGIN_SUCCEED);
                } else {
                    jobj.put("status", 0);
                    jobj.put("msg", ConstMsg.USER_DISABLED);
                }
            } else {

                // 登录验证失败
                jobj.put("status", 0);
                jobj.put("msg", ConstMsg.PASSWORD_WRONG);
            }
            response.getWriter().println(jobj);
        } catch (ServiceException e) {
            System.err.println("LoginServlet中loginCheck方法调用Services层getUser()出现异常");
        } catch (IOException e) {
            System.err.println("LoginServlet中loginCheck方法IOException");
        }

    }

    @RequestMapping("/loginToCms")
    protected String loginToCms(HttpServletRequest request, HttpServletResponse response) {
        String view="";
        try {

            String employeeId = request.getParameter("employeeId");
            String password = request.getParameter("password");
            List<LoginDto> list = null;
            list = loginServiceI.getUser(employeeId, password);
            if (list != null && list.size() > 0) {
                // 登录验证成功

                EmployeeDto empStatus = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                if ("0".equals(empStatus.getStatus().trim())) {// 验证用户是否禁用

                    if ("123456".equals(password)) {
                        //response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");

                        view="redirect:/updatepassword.jsp";
                    } else {
                        String employee_id = request.getParameter("employeeId");
                        // 通过 empid查出职位 position_id
                        // 然后 查询 职位对应的 菜单信息
                        EmployeeDto empDto = null;
                        empDto = employeeServiceI.queryEmployeeById(Integer.parseInt(employee_id));
                        Integer position_id = empDto.getPosition_id();
                        // 获取当前登录用户的所有权限操作
                        HttpSession session = request.getSession();
                        empDto = employeeServiceI.queryEmployeeById(Integer.parseInt(employee_id));
                        session.setAttribute("user", empDto);
                        List<Position_Menu_RelationsDto> menus = null;
                        menus = position_Menu_RelationsServiceI.queryPositionMenuRelationsByPositionId(position_id);
                        session.setAttribute("menus", menus);
                        List<ListMenuDto> limits = null;
                        limits = position_Menu_RelationsServiceI.queryLimits(position_id);
                        session.setAttribute("limits", limits);
                        //response.sendRedirect(request.getContextPath() + "/ControlServlet?method=countAll");

                        view="redirect:/ControlServlet/countAll";
                    }
                } else {
                    // 登录验证失败
                   // response.sendRedirect(request.getContextPath() + "/login.jsp");
                    view="redirect:/login.jsp";
                }
            } else {

                // 登录验证失败
                //response.sendRedirect(request.getContextPath() + "/login.jsp");

                view="redirect:/login.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    @RequestMapping("/updatePassword")
    protected String updatePassword(HttpServletRequest request, HttpServletResponse response) {
        // 第一次session 创建的时候 是在 updata页面修改完密码后
        String view="";
        String employeeId = request.getParameter("employeeId");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");

        try {
            if (employeeId != null && employeeId != "" && oldpassword != null && oldpassword != ""
                    && newpassword != null && newpassword != "") {
                List<LoginDto> list = null;

                list = loginServiceI.getUser(employeeId, oldpassword);
                if (list != null && list.size() > 0) {
                    // 登录验证成功

                    EmployeeDto empStatus = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                    if ("0".equals(empStatus.getStatus().trim())) {

                        loginServiceI.updatePassword(employeeId, newpassword);
                        EmployeeDto empDto = null;
                        empDto = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                        Integer position_id = empDto.getPosition_id();
                        // 获取当前登录用户的所有权限操作
                        HttpSession session = request.getSession();
                        empDto = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                        session.setAttribute("user", empDto);
                        List<Position_Menu_RelationsDto> menus = null;
                        menus = position_Menu_RelationsServiceI.queryPositionMenuRelationsByPositionId(position_id);
                        session.setAttribute("menus", menus);
                        List<ListMenuDto> limits = null;
                        limits = position_Menu_RelationsServiceI.queryLimits(position_id);
                        session.setAttribute("limits", limits);
                        //response.sendRedirect(request.getContextPath() + "/ControlServlet/countAll");
                        view="redirect:/ControlServlet/countAll";
                    } else {
                        // 登录验证失败
                        //response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");
                        view="redirect:/updatepassword.jsp";
                    }
                } else {
                    // 登录验证失败
                    //response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");
                    view="redirect:/updatepassword.jsp";
                }
            } else {

                //response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");
                view="redirect:/updatepassword.jsp";
            }

        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return view;
    }

    @RequestMapping("/logout")
    protected String logout(HttpServletRequest request, HttpServletResponse response) {
        String view="";
       /* try {
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        view="redirect:/login.jsp";
        return view;
    }


}

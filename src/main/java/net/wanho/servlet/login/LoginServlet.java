/*
package net.wanho.servlet.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import net.wanho.consts.ConstMsg;
import net.wanho.dto.EmployeeDto;
import net.wanho.dto.ListMenuDto;
import net.wanho.dto.LoginDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.EmployeeServiceI;
import net.wanho.service.LoginServiceI;
import net.wanho.service.PositionServiceI;
import net.wanho.service.Position_Menu_RelationsServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private LoginServiceI loginServiceI;
    private EmployeeServiceI employeeServiceI;
    private Position_Menu_RelationsServiceI position_Menu_RelationsServiceI;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
        // 1. 从 application 域对象中得到 IOC 容器的引用
        ServletContext servletContext = getServletContext();
        */
/*ApplicationContext ctx = (ApplicationContext)
        servletContext.getAttribute("ApplicationContext");*//*

        ApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // 2. 从 IOC 容器中得到需要的 bean
        loginServiceI = ctx.getBean(LoginServiceI.class);
        employeeServiceI = ctx.getBean(EmployeeServiceI.class);
        position_Menu_RelationsServiceI = ctx.getBean(Position_Menu_RelationsServiceI.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void loginCheck(HttpServletRequest request, HttpServletResponse response) {
        */
/*LoginServiceI loginServiceI = (LoginServiceI) ObjectFactory.getObject("loginServiceI");
		EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");*//*

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

    protected void loginToCms(HttpServletRequest request, HttpServletResponse response) {
        try {
           */
/* LoginServiceI loginServiceI = (LoginServiceI) ObjectFactory.getObject("loginServiceI");
            Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                    .getObject("position_Menu_RelationsServiceI");
           *//*

            //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
            String employeeId = request.getParameter("employeeId");
            String password = request.getParameter("password");
            List<LoginDto> list = null;
            list = loginServiceI.getUser(employeeId, password);
            if (list != null && list.size() > 0) {
                // 登录验证成功

                EmployeeDto empStatus = employeeServiceI.queryEmployeeById(Integer.parseInt(employeeId));
                if ("0".equals(empStatus.getStatus().trim())) {// 验证用户是否禁用

                    if ("123456".equals(password)) {
                        response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");

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
                        response.sendRedirect(request.getContextPath() + "/ControlServlet?method=countAll");
                    }
                } else {
                    // 登录验证失败
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                }
            } else {

                // 登录验证失败
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void updatePassword(HttpServletRequest request, HttpServletResponse response) {
        // 第一次session 创建的时候 是在 updata页面修改完密码后
        */
/*LoginServiceI loginServiceI = (LoginServiceI) ObjectFactory.getObject("loginServiceI");
        EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                .getObject("position_Menu_RelationsServiceI");
        *//*

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
                        response.sendRedirect(request.getContextPath() + "/ControlServlet?method=countAll");
                    } else {
                        // 登录验证失败
                        response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");
                    }
                } else {
                    // 登录验证失败
                    response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");
                }
            } else {

                response.sendRedirect(request.getContextPath() + "/updatepassword.jsp");

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
*/

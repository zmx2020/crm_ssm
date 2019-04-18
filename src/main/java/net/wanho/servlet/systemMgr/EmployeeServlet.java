package net.wanho.servlet.systemMgr;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import net.wanho.consts.ConstMsg;
import net.wanho.dto.EmployeeDto;
import net.wanho.entity.Department;
import net.wanho.entity.Position;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.DepartmentServiceI;
import net.wanho.service.EmployeeServiceI;
import net.wanho.service.PositionServiceI;
import net.wanho.util.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeServiceI employeeServiceI;
    private DepartmentServiceI departmentServiceI;
    private PositionServiceI positionServiceI;

    @Override
    public void init() throws ServletException {
        // 1. 从 application 域对象中得到 IOC 容器的引用
        ServletContext servletContext = getServletContext();
        /*ApplicationContext ctx = (ApplicationContext)
        servletContext.getAttribute("ApplicationContext");*/
        ApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // 2. 从 IOC 容器中得到需要的 bean
        employeeServiceI = ctx.getBean(EmployeeServiceI.class);
        departmentServiceI=ctx.getBean(DepartmentServiceI.class);
        positionServiceI=ctx.getBean(PositionServiceI.class);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
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

    protected void getAllEmployee(HttpServletRequest request, HttpServletResponse response) {

        //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        String emmployee_id = request.getParameter("emmployee_id");
        String emmployee_name = request.getParameter("emmployee_name");
        String currentPage = request.getParameter("currentPage");
        // 条件操作符
        Map<String, String> operator = new HashMap<String, String>();
        // 搜索条件
        Map<String, Object> where = new HashMap<String, Object>();

        try {
            if (emmployee_id != null && emmployee_id != "") {
                operator.put("employee_id", "=");

                where.put("employee_id", emmployee_id);
            }
            if (emmployee_name != null && emmployee_name != "") {

                operator.put("employee_name", "like ");
                where.put("employee_name", "%" + emmployee_name + "%");

            }
            PageBean<EmployeeDto> pageBean = null;
            if (currentPage == null) {
                pageBean = employeeServiceI.pageFindEmployee(1, where, operator);
            } else {
                pageBean = employeeServiceI.pageFindEmployee(Integer.valueOf(currentPage), where, operator);
            }
            request.setAttribute("pageBean", pageBean);

            request.getRequestDispatcher("/WEB-INF/view/systemSettings/manage/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    protected void findEmployeeById(HttpServletRequest request, HttpServletResponse response) {
        String employee_id = request.getParameter("employee_id");
        //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        //DepartmentServiceI departmentServiceI = (DepartmentServiceI) ObjectFactory.getObject("departmentServiceI");
        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");
        List<Department> departments = departmentServiceI.queryAllDepartment();
        List<Position> positions = positionServiceI.queryAllPosition();

        EmployeeDto employeeDto = new EmployeeDto();
        try {
            employeeDto = employeeServiceI.queryEmployeeById(Integer.parseInt(employee_id));
            request.setAttribute("employeeDto", employeeDto);
            request.setAttribute("departments", departments);
            request.setAttribute("positions", positions);
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/manage/update.jsp").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void getDeapartAndPostionInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
           /* DepartmentServiceI departmentServiceI = (DepartmentServiceI) ObjectFactory.getObject("departmentServiceI");
            PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");
            */
            List<Department> departments = departmentServiceI.queryAllDepartment();
            List<Position> positions = positionServiceI.queryAllPosition();
            request.setAttribute("departments", departments);
            request.setAttribute("positions", positions);
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/manage/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void checkParentEmployee(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = new JSONObject();
        try {

            String parentId = request.getParameter("");
            Integer parentId1;

            response.getWriter().write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        try {
            String employee_name = request.getParameter("manage-name");
            String department_id = request.getParameter("manage-department_id");
            String position_id = request.getParameter("manage-position_id");
            String phone = request.getParameter("manage-mobile");
            String email = request.getParameter("manage-email");
            String parent_employee_id = request.getParameter("parent_employee_id");

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmployee_name(employee_name);
            employeeDto.setDepartment_id(Integer.parseInt(department_id));
            employeeDto.setPosition_id(Integer.parseInt(position_id));
            employeeDto.setPhone(phone);
            employeeDto.setEmail(email);
            employeeDto.setParent_employee_id(Integer.parseInt(parent_employee_id));
            employeeServiceI.addEmployee(employeeDto);
            response.sendRedirect(request.getContextPath() + "/EmployeeServlet?method=getAllEmployee");

        } catch (ServiceException | IOException e1) {
            e1.printStackTrace();
        }
    }

    protected void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        try {
            String employee_id = request.getParameter("employee_id");
            String employee_name = request.getParameter("manage-name");
            String department_id = request.getParameter("manage-department_id");
            String position_id = request.getParameter("manage-position_id");
            String phone = request.getParameter("manage-mobile");
            String email = request.getParameter("manage-email");
            String parent_employee_id = request.getParameter("parent_employee_id");

            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEmployee_id(Integer.parseInt(employee_id));
            employeeDto.setEmployee_name(employee_name);
            employeeDto.setDepartment_id(Integer.parseInt(department_id));
            employeeDto.setPosition_id(Integer.parseInt(position_id));
            employeeDto.setPhone(phone);
            employeeDto.setEmail(email);
            employeeDto.setParent_employee_id(Integer.parseInt(parent_employee_id));
            employeeServiceI.updateEmployee(employeeDto);

            response.sendRedirect(request.getContextPath() + "/EmployeeServlet?method=getAllEmployee");
        } catch (ServiceException | IOException e1) {
            e1.printStackTrace();
        }

    }

    protected void updateEmployeeStatus(HttpServletRequest request, HttpServletResponse response) {
        //EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");
        JSONObject jobj = new JSONObject();
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            String employee_id = request.getParameter("employee_id");
            String status = request.getParameter("status");
            employeeServiceI.updateEmployeeStatus(Integer.parseInt(employee_id), status);
            jobj.put("status", 0);
        } catch (ServiceException | IOException e) {
            e.printStackTrace();
            jobj.put("status", 1);
            jobj.put("msg", ConstMsg.EMPLOYEE_STATUS_UPDATE_FAIL);
        }

        pw.println(jobj);
    }

}

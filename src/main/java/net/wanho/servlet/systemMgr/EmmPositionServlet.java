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
import net.wanho.dto.MenuDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.entity.Position;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.EmployeeServiceI;
import net.wanho.service.MenuServiceI;
import net.wanho.service.PositionServiceI;
import net.wanho.service.Position_Menu_RelationsServiceI;
import net.wanho.util.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/EmmPositionServlet")
public class EmmPositionServlet extends HttpServlet {
    private PositionServiceI positionServiceI;
    private Position_Menu_RelationsServiceI position_Menu_RelationsServiceI;
    private EmployeeServiceI employeeServiceI;
    private MenuServiceI menuServiceI;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
        // 1. 从 application 域对象中得到 IOC 容器的引用
        ServletContext servletContext = getServletContext();
        /*ApplicationContext ctx = (ApplicationContext)
        servletContext.getAttribute("ApplicationContext");*/
        ApplicationContext ctx =
                WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // 2. 从 IOC 容器中得到需要的 bean
        positionServiceI = ctx.getBean(PositionServiceI.class);
        position_Menu_RelationsServiceI=ctx.getBean(Position_Menu_RelationsServiceI.class);
        employeeServiceI=ctx.getBean(EmployeeServiceI.class);
        menuServiceI=ctx.getBean(MenuServiceI.class);
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

    protected void getAllEmmPosition(HttpServletRequest request, HttpServletResponse response) {

        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");
        /*
         * MenuServiceI menuServiceI = (MenuServiceI)
		 * ObjectFactory.getObject("menuServiceI");
		 */
        String position_name = request.getParameter("position_name");
        String currentPage = request.getParameter("currentPage");
        // 条件操作符
        Map<String, String> operator = new HashMap<String, String>();
        // 搜索条件
        Map<String, Object> where = new HashMap<String, Object>();

        try {

            if (position_name != null && position_name != "") {
                operator.put("POSITION_NAME", "like ");
                where.put("POSITION_NAME", "%" + position_name + "%");

            }
            PageBean<Position> pageBean = null;
            if (currentPage == null) {
                pageBean = positionServiceI.pageFindPosition(1, where, operator);
            } else {
                pageBean = positionServiceI.pageFindPosition(Integer.valueOf(currentPage), where, operator);
            }
            request.setAttribute("pageBean", pageBean);
            /*
			 * List<MenuDto> menuDtos=menuServiceI.queryAllMenu();
			 * 
			 * request.setAttribute("menuDtos", menuDtos);
			 */
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/position/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    protected void addPosition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");
        String position_name = request.getParameter("position_name");
        String position_Level = request.getParameter("position_Level");

        Position position = new Position();
        position.setPosition_name(position_name);
        position.setPosition_level(position_Level);
        try {
            positionServiceI.addPosition(position);
            response.sendRedirect(request.getContextPath() + "/EmmPositionServlet?method=getAllEmmPosition");
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void showAddPosition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/position/create.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void positionNameCheck(HttpServletRequest request, HttpServletResponse response) {

        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");

        String position_name = request.getParameter("position_name");
        String position_id = request.getParameter("position_id");
        boolean isExistPositionName = false;
        JSONObject jobj = new JSONObject();

        try {
            if (position_id != null && position_id != "") {
                Position position = null;
                position = positionServiceI.queryPositionById(Integer.parseInt(position_id));
                if (!(position.getPosition_name().equals(position_name))) {

                    isExistPositionName = positionServiceI.isExistPositionName(position_name);

                    if (isExistPositionName) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.POSITION_NAME_EXIST);
                    } else {
                        jobj.put("status", true);
                    }
                } else {
                    jobj.put("status", true);
                }

            } else {
                isExistPositionName = positionServiceI.isExistPositionName(position_name);

                if (isExistPositionName) {
                    jobj.put("status", false);
                    jobj.put("msg", ConstMsg.POSITION_NAME_EXIST);
                } else {
                    jobj.put("status", true);
                }
            }
            PrintWriter pw = response.getWriter();
            pw.println(jobj);
        } catch (NumberFormatException | ServiceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void deletePostionCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
       /* Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                .getObject("position_Menu_RelationsServiceI");
        EmployeeServiceI employeeServiceI = (EmployeeServiceI) ObjectFactory.getObject("employeeServiceI");*/
        List<Position_Menu_RelationsDto> position_Menu_RelationsDtos = null;
        List<EmployeeDto> employeeDtos = null;
        JSONObject jobj = new JSONObject();
        try {
            String position_id = request.getParameter("position_id");
            position_Menu_RelationsDtos = position_Menu_RelationsServiceI
                    .queryPositionMenuRelationsByPositionId(Integer.parseInt(position_id));
            employeeDtos = employeeServiceI.queryEmployeeByPositionId(Integer.parseInt(position_id));
            if (position_Menu_RelationsDtos.size() > 0) {
                jobj.put("status", false);
                jobj.put("msg", ConstMsg.POSITION_MENU_RELATION_FAIL);
            } else if (employeeDtos.size() > 0) {
                jobj.put("status", false);
                jobj.put("msg", ConstMsg.POSITION_EMPLOYEE_RELATION_FAIL);
            } else {
                jobj.put("status", true);
                jobj.put("msg", "");
            }

            PrintWriter pw = response.getWriter();
            pw.println(jobj);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void deletePosition(HttpServletRequest request, HttpServletResponse response) {
        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");
        String position_id = request.getParameter("position_id");
        try {
            positionServiceI.delPositionById(Integer.parseInt(position_id));
            response.sendRedirect(request.getContextPath() + "/EmmPositionServlet?method=getAllEmmPosition");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void getUpdatePostionDetailById(HttpServletRequest request, HttpServletResponse response) {
        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");

        String position_id = request.getParameter("position_id");
        try {
            Position position = positionServiceI.queryPositionById(Integer.parseInt(position_id));
            request.setAttribute("position", position);
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/position/update.jsp").forward(request, response);
        } catch (ServiceException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    protected void updatePosition(HttpServletRequest request, HttpServletResponse response) {
        //PositionServiceI positionServiceI = (PositionServiceI) ObjectFactory.getObject("positionServiceI");

        String position_name = request.getParameter("position_name");
        String position_Level = request.getParameter("position_Level");
        String position_id = request.getParameter("position_id");
        Position position = new Position();
        position.setPosition_id(Integer.parseInt(position_id));
        position.setPosition_level(position_Level);
        position.setPosition_name(position_name);
        try {
            positionServiceI.updatePosition(position);
            response.sendRedirect(request.getContextPath() + "/EmmPositionServlet?method=getAllEmmPosition");
        } catch (ServiceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void getLinkPostionDetailById(HttpServletRequest request, HttpServletResponse response) {
        /*Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                .getObject("position_Menu_RelationsServiceI");
        MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
*/
        JSONObject jobj = new JSONObject();
        String position_id = request.getParameter("position_id");
        List<Position_Menu_RelationsDto> position_Menu_RelationsDtos = null;
        try {

            List<MenuDto> menuDtos = menuServiceI.queryAllMenu();
            jobj.put("menuDtos", menuDtos);
            position_Menu_RelationsDtos = position_Menu_RelationsServiceI
                    .queryPositionMenuRelationsByPositionId(Integer.parseInt(position_id));
            jobj.put("position_Menu_RelationsDtos", position_Menu_RelationsDtos);
            PrintWriter pw = response.getWriter();
            pw.println(jobj);
			/*
			 * request.getRequestDispatcher(
			 * "/WEB-INF/view/systemSettings/position/references.jsp").forward(request,
			 * response);
			 */
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void positionLinks(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + "/EmmPositionServlet?method=getAllEmmPosition");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void updataPositionMenuRelations(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException {
        JSONObject jobj = new JSONObject();
        try {
            PrintWriter pw = response.getWriter();

            String MenusStr = request.getParameter("menus");
            String referenceposition_id = request.getParameter("referenceposition_id");
            // 转换menu_id
            String[] arrayMenus = MenusStr.split("-");
            Integer[] intArrayMenus = new Integer[arrayMenus.length];
            for (int i = 0; i < arrayMenus.length; i++) {
                intArrayMenus[i] = Integer.parseInt(arrayMenus[i]);
            }

            jobj.put("status", false);
            jobj.put("msg", "菜单更新失败！");
            Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                    .getObject("position_Menu_RelationsServiceI");

            position_Menu_RelationsServiceI.updPositionMenuRelations(intArrayMenus,
                    Integer.parseInt(referenceposition_id));

            jobj.put("status", true);
            jobj.put("msg", "");
            pw.println(jobj);

        } catch (IOException e) {
            e.printStackTrace();
        }
		/*
		 * response.sendRedirect(request.getContextPath() +
		 * "/EmmPositionServlet?method=getAllEmmPosition");
		 */
    }

}

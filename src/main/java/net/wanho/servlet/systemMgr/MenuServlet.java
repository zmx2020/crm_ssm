/*
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
import net.wanho.dto.MenuDto;
import net.wanho.dto.Position_Menu_RelationsDto;
import net.wanho.entity.Menu;
import net.wanho.exception.ServiceException;
import net.wanho.factory.ObjectFactory;
import net.wanho.service.EmployeeServiceI;
import net.wanho.service.MenuServiceI;
import net.wanho.service.Position_Menu_RelationsServiceI;
import net.wanho.util.PageBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
    private MenuServiceI menuServiceI;
    private Position_Menu_RelationsServiceI position_Menu_RelationsServiceI;

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
        menuServiceI = ctx.getBean(MenuServiceI.class);
        position_Menu_RelationsServiceI= ctx.getBean(Position_Menu_RelationsServiceI.class);
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

    protected void getAllMenu(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        String name = request.getParameter("name");
        String currentPage = request.getParameter("currentPage");

        // 条件操作符
        Map<String, String> operator = new HashMap<String, String>();
        // 搜索条件
        Map<String, Object> where = new HashMap<String, Object>();
        try {
            if (name != null && name != "") {
                operator.put("menu_name", "like");
                where.put("menu_name", "%" + name + "%");
            }
            PageBean<MenuDto> pageBean = null;
            if (currentPage == null) {
                pageBean = menuServiceI.pageFindMenu(1, where, operator);
            } else {
                pageBean = menuServiceI.pageFindMenu(Integer.valueOf(currentPage), where, operator);
            }
            request.setAttribute("pageBean", pageBean);

            request.getRequestDispatcher("/WEB-INF/view/systemSettings/menu/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    protected void getAllParentMenu(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        try {
            List<Menu> parentMenu = menuServiceI.queryParentMenu();
            request.setAttribute("parentMenu", parentMenu);
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/menu/create.jsp").forward(request, response);
        } catch (ServiceException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void CheckMenuNameAndURL(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        String menu_url = request.getParameter("menu_url");
        String menu_name = request.getParameter("menu_name");
        String menu_id = request.getParameter("menu_id");
        boolean isExistMenuName = false;
        boolean isExistMenuUrl = false;
        JSONObject jobj = new JSONObject();
        MenuDto menuDto = null;
        try {
            if (menu_id != null && menu_id != "") {
                menuDto = menuServiceI.queryMenuById(Integer.parseInt(menu_id));
                if ((!menuDto.getMenu_name().equals(menu_name)) && (!menuDto.getMenu_url().equals(menu_url))) {
                    isExistMenuName = menuServiceI.isExistMenuName(menu_name);
                    isExistMenuUrl = menuServiceI.isExistMenuUrl(menu_url);
                    if (isExistMenuName && isExistMenuUrl) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.MENU_NAME_URL_EXIST);
                    } else if (isExistMenuName) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.MENU_NAME_EXIST);
                    } else if (isExistMenuUrl) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.MENU_URL_EXIST);
                    } else {
                        jobj.put("status", true);
                    }
                } else if (!menuDto.getMenu_name().equals(menu_name)) {
                    isExistMenuName = menuServiceI.isExistMenuName(menu_name);
                    if (isExistMenuName) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.MENU_NAME_EXIST);
                    } else {
                        jobj.put("status", true);
                    }
                } else if (!menuDto.getMenu_url().equals(menu_url)) {
                    isExistMenuUrl = menuServiceI.isExistMenuUrl(menu_url);
                    if (isExistMenuUrl) {
                        jobj.put("status", false);
                        jobj.put("msg", ConstMsg.MENU_URL_EXIST);
                    } else {
                        jobj.put("status", true);
                    }
                } else {
                    jobj.put("status", true);
                }

            } else {

                isExistMenuName = menuServiceI.isExistMenuName(menu_name);
                isExistMenuUrl = menuServiceI.isExistMenuUrl(menu_url);
                if (isExistMenuName && isExistMenuUrl) {
                    jobj.put("status", false);
                    jobj.put("msg", ConstMsg.MENU_NAME_URL_EXIST);
                } else if (isExistMenuName) {
                    jobj.put("status", false);
                    jobj.put("msg", ConstMsg.MENU_NAME_EXIST);
                } else if (isExistMenuUrl) {
                    jobj.put("status", false);
                    jobj.put("msg", ConstMsg.MENU_URL_EXIST);
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

    protected void addMenu(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        String menu_name = request.getParameter("menu-name");
        String menu_url = request.getParameter("menu-url");
        String menu_parent_id = request.getParameter("menu-parent_id");
        String pictures = request.getParameter("pictures");
        Menu menu = new Menu();
        menu.setMenu_name(menu_name);
        menu.setMenu_url(menu_url);

        menu.setParent_menu_id(Integer.parseInt(menu_parent_id));
        menu.setPictures(pictures);

        try {
            menuServiceI.addMenu(menu);
            response.sendRedirect(request.getContextPath() + "/MenuServlet?method=getAllMenu");
        } catch (ServiceException | IOException e) {
            e.printStackTrace();
            try {
                response.sendRedirect(request.getContextPath() + "/MenuServlet?method=getAllParentMenu");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    protected void deleteMenuById(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        String menu_id = request.getParameter("menu_id");
        try {
            menuServiceI.deleteMenu(Integer.parseInt(menu_id));
            response.sendRedirect(request.getContextPath() + "/MenuServlet?method=getAllMenu");
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

    protected void getUpdateMenudetailById(HttpServletRequest request, HttpServletResponse response) {
        //MenuServiceI menuServiceI = (MenuServiceI) ObjectFactory.getObject("menuServiceI");
        String menuId = request.getParameter("menuId");
        try {
            MenuDto menuDto = menuServiceI.queryMenuById(Integer.parseInt(menuId));
            List<Menu> parentMenu = menuServiceI.queryParentMenu();
            request.setAttribute("parentMenu", parentMenu);
            request.setAttribute("menuDto", menuDto);
            request.getRequestDispatcher("/WEB-INF/view/systemSettings/menu/update.jsp").forward(request, response);
        } catch (ServiceException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    protected void updateMenu(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + "/MenuServlet?method=getAllMenu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void checkDeleteMenuId(HttpServletRequest request, HttpServletResponse response) {
       */
/* Position_Menu_RelationsServiceI position_Menu_RelationsServiceI = (Position_Menu_RelationsServiceI) ObjectFactory
                .getObject("position_Menu_RelationsServiceI");*//*

        List<Position_Menu_RelationsDto> position_Menu_RelationsDtos = null;
        JSONObject jobj = new JSONObject();
        try {
            String menu_id = request.getParameter("menu_id");
            position_Menu_RelationsDtos = position_Menu_RelationsServiceI
                    .queryPositionMenuRelationsByMenuId(Integer.parseInt(menu_id));
            if (position_Menu_RelationsDtos.size() > 0) {
                jobj.put("status", false);
                jobj.put("msg", ConstMsg.MENU_POSITION_RELATION_FAIL);
            } else {
                jobj.put("status", true);
                jobj.put("msg", "");
            }

            PrintWriter pw = response.getWriter();
            pw.println(jobj);

			*/
/*
             * response.sendRedirect(request.getContextPath() +
			 * "/MenuServlet?method=getAllMenu");
			 *//*

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

}
*/

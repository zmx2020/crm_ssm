package net.wanho.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.wanho.dto.Position_Menu_RelationsDto;

public class LoginFilter implements Filter {

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		List<Position_Menu_RelationsDto> menus = null;

		if (request.getRequestURI().contains(".woff")  || request.getRequestURI().contains(".woff2") || request.getRequestURI().contains(".css") || request.getRequestURI().contains(".js") || request.getRequestURI().contains(".jpg") || request.getRequestURI().contains(".png") || request.getRequestURI().contains("/login.jsp") || request.getRequestURI().contains("/updatepassword.jsp") || request.getRequestURI().contains("/LoginServlet")) {
			// 访问的页面是login 及 loginservlet 不过滤直接放行
			chain.doFilter(request, response);
		} else {// 访问的地址不是login 及 loginservlet

			if (session.getAttribute("user") == null) {// 判断session user是否为null
				// 未登录跳转到登录页面
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				// 请求路径不是login.jsp
				if (session.getAttribute("menus") != null) {
					menus = (List<Position_Menu_RelationsDto>) session.getAttribute("menus");
					String url = request.getServletPath().substring(1); // idpstat.jsp 返回调用servlet的部分url
					boolean flag=false;
					for (Position_Menu_RelationsDto temp : menus) {
						String menu_url=temp.getMenu_url();
						if (menu_url.contains(url.substring(1))) {
							flag=true;
							break;
						}
					}
					if(flag) {//放行
						chain.doFilter(request, response);
					}else {//没有改路径的访问权限 设置403 无访问权限错误代码
						response.sendError(403);
					}
					// request.getQueryString();//action=idp.sptopn 返回url路径后面的查询字符串
				} else {
					//没有获取到menus对象让其重新登录
					response.sendRedirect(request.getContextPath() + "/login.jsp");
				}
			}			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

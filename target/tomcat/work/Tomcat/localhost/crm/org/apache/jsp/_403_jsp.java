/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-15 13:29:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _403_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>403ç¦æ­¢é¡µé¢æ¨¡æ¿</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("@import url(\"https://fonts.googleapis.com/css?family=Share+Tech+Mono|Montserrat:700\");\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    border: 0;\r\n");
      out.write("    font-size: 100%;\r\n");
      out.write("    font: inherit;\r\n");
      out.write("    vertical-align: baseline;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    color: inherit;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("    background-image: linear-gradient(120deg, #4f0088 0%, #000000 100%);\r\n");
      out.write("    height: 100vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("    font-size: 45vw;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    width: 100vw;\r\n");
      out.write("    z-index: 1;\r\n");
      out.write("    color: #ffffff26;\r\n");
      out.write("    text-shadow: 0 0 50px rgba(0, 0, 0, 0.07);\r\n");
      out.write("    top: 50%;\r\n");
      out.write("    -webkit-transform: translateY(-50%);\r\n");
      out.write("            transform: translateY(-50%);\r\n");
      out.write("    font-family: \"Montserrat\", monospace;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div {\r\n");
      out.write("    background: rgba(0, 0, 0, 0);\r\n");
      out.write("    width: 70vw;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    top: 50%;\r\n");
      out.write("    -webkit-transform: translateY(-50%);\r\n");
      out.write("            transform: translateY(-50%);\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    padding: 30px 30px 10px;\r\n");
      out.write("    box-shadow: 0 0 150px -20px rgba(0, 0, 0, 0.5);\r\n");
      out.write("    z-index: 3;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("P {\r\n");
      out.write("    font-family: \"Share Tech Mono\", monospace;\r\n");
      out.write("    color: #f5f5f5;\r\n");
      out.write("    margin: 0 0 20px;\r\n");
      out.write("    font-size: 17px;\r\n");
      out.write("    line-height: 1.2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("span {\r\n");
      out.write("    color: #f0c674;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("i {\r\n");
      out.write("    color: #8abeb7;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("b {\r\n");
      out.write("    color: #81a2be;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a.avatar {\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    bottom: 15px;\r\n");
      out.write("    right: -100px;\r\n");
      out.write("    -webkit-animation: slide 0.5s 4.5s forwards;\r\n");
      out.write("            animation: slide 0.5s 4.5s forwards;\r\n");
      out.write("    display: block;\r\n");
      out.write("    z-index: 4\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a.avatar img {\r\n");
      out.write("    border-radius: 100%;\r\n");
      out.write("    width: 44px;\r\n");
      out.write("    border: 2px solid white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@-webkit-keyframes slide {\r\n");
      out.write("    from {\r\n");
      out.write("        right: -100px;\r\n");
      out.write("        -webkit-transform: rotate(360deg);\r\n");
      out.write("                transform: rotate(360deg);\r\n");
      out.write("        opacity: 0;\r\n");
      out.write("    }\r\n");
      out.write("    to {\r\n");
      out.write("        right: 15px;\r\n");
      out.write("        -webkit-transform: rotate(0deg);\r\n");
      out.write("                transform: rotate(0deg);\r\n");
      out.write("        opacity: 1;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes slide {\r\n");
      out.write("    from {\r\n");
      out.write("        right: -100px;\r\n");
      out.write("        -webkit-transform: rotate(360deg);\r\n");
      out.write("                transform: rotate(360deg);\r\n");
      out.write("        opacity: 0;\r\n");
      out.write("    }\r\n");
      out.write("    to {\r\n");
      out.write("        right: 15px;\r\n");
      out.write("        -webkit-transform: rotate(0deg);\r\n");
      out.write("                transform: rotate(0deg);\r\n");
      out.write("        opacity: 1;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>403</h1>\r\n");
      out.write("<div><p>> <span>ERROR CODE</span>: \"<i>HTTP 403 Forbidden</i>\"</p>\r\n");
      out.write("<p>> <span>ERROR DESCRIPTION</span>: \"<i>Access Denied. You Do Not Have The Permission To Access This Page On This Server</i>\"</p>\r\n");
      out.write("<p>> <span>ERROR POSSIBLY CAUSED BY</span>: [<b>execute access forbidden, read access forbidden, write access forbidden, ssl required, ssl 128 required, ip address rejected, client certificate required, site access denied, too many users, invalid configuration, password change, mapper denied access, client certificate revoked, directory listing denied, client access licenses exceeded, client certificate is untrusted or invalid, client certificate has expired or is not yet valid, passport logon failed, source access denied, infinite depth is denied, too many requests from the same client ip</b>...]</p>\r\n");
      out.write("<p>> <span>SOME PAGES ON THIS SERVER THAT YOU DO HAVE PERMISSION TO ACCESS</span>: [<a href=\"/\">Home Page</a>, <a href=\"/\">About Us</a>, <a href=\"/\">Contact Us</a>, <a href=\"/\">Blog</a>...]</p><p>> <span>HAVE A NICE DAY SIR AXLEROD :-)</span></p>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var str = document.getElementsByTagName('div')[0].innerHTML.toString();\r\n");
      out.write("var i = 0;\r\n");
      out.write("document.getElementsByTagName('div')[0].innerHTML = \"\";\r\n");
      out.write("\r\n");
      out.write("setTimeout(function() {\r\n");
      out.write("    var se = setInterval(function() {\r\n");
      out.write("        i++;\r\n");
      out.write("        document.getElementsByTagName('div')[0].innerHTML = str.slice(0, i) + \"|\";\r\n");
      out.write("        if (i == str.length) {\r\n");
      out.write("            clearInterval(se);\r\n");
      out.write("            document.getElementsByTagName('div')[0].innerHTML = str;\r\n");
      out.write("        }\r\n");
      out.write("    }, 10);\r\n");
      out.write("},0);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

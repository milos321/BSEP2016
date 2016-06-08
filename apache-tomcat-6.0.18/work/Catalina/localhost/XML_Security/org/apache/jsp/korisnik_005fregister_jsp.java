package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class korisnik_005fregister_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Registrovanje</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        \t<div class=\"form-top\">\r\n");
      out.write("                        \t\t<div class=\"form-top-left\">\r\n");
      out.write("                        \t\t\t<h3>Dobrodosli </h3>\r\n");
      out.write("                            \t\t<p>Registrovanje korisnika:</p>\r\n");
      out.write("                        \t\t</div>\r\n");
      out.write("                        \t\t<div class=\"form-top-right\">\r\n");
      out.write("                        \t\t\t<i class=\"fa fa-lock\"></i>\r\n");
      out.write("                        \t\t</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-bottom\">\r\n");
      out.write("\t\t\t                    <form role=\"form\" action=\"Registrovanje\" method=\"post\" class=\"login-form\">\r\n");
      out.write("\t\t\t                    \t<div class=\"form-group\">\r\n");
      out.write("\t\t\t                    \t\t<label class=\"sr-only\" for=\"form-username\">Username</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"text\" name=\"username\" placeholder=\"Username\" class=\"form-username form-control\" id=\"form-username\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"\">Password</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"password\" name=\"password\" placeholder=\"Password\" class=\" form-control\" id=\"\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"\">Repeat password</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"password\" name=\"repeat_password\" placeholder=\"Repeat password\" class=\" form-control\" id=\"\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"\">Ime</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"text\" name=\"ime\" placeholder=\"Ime\" class=\" form-control\" id=\"\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"\">Prezime</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"text\" name=\"prezime\" placeholder=\"Prezime\" class=\" form-control\" id=\"\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        \r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"\">E-mail</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"text\" name=\"email\" placeholder=\"E-mail\" class=\" form-control\" id=\"\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t               \r\n");
      out.write("\t\t\t                        <button type=\"submit\" class=\"btn\">Registruj se!</button>\r\n");
      out.write("\t\t\t                    </form>\r\n");
      out.write("\t\t              \r\n");
      out.write("           \t\t\t\t\t </div>\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

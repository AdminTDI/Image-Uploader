package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Image Uploader</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
      out.write("        <style>\n");
      out.write("            h1{\n");
      out.write("                background-color: dimgrey;\n");
      out.write("                color: white;\n");
      out.write("                width: 500px;\n");
      out.write("                padding: 30px;\n");
      out.write("            }\n");
      out.write("            fieldset{\n");
      out.write("                width: 530px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h1>Profile Registration</h1>\n");
      out.write("        <fieldset>\n");
      out.write("            <legend><b>Upload Your Image</b></legend>\n");
      out.write("            <form action=\"profile\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Fist Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"fn\" size=\"25\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Last Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"ln\" size=\"25\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Profile Image: </td>\n");
      out.write("                        <td><input type=\"file\" name=\"pi\" size=\"25\" onchange=\"previewImage(this)\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td>\n");
      out.write("                            <div id=\"imgcontainer\">\n");
      out.write("                                <img id=\"preview\" src=\"#\" alt=\"your image\"/>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Done\"/> <input type=\"reset\" value=\"Cancel\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </fieldset>\n");
      out.write("    </center>\n");
      out.write("    <script>\n");
      out.write("        function previewImage(input) {\n");
      out.write("            if (input.files && input.files[0]) {\n");
      out.write("                var reader = new FileReader();\n");
      out.write("\n");
      out.write("                reader.onload = function (e) {\n");
      out.write("                    $('#preview')\n");
      out.write("                            .attr('src', e.target.result)\n");
      out.write("                            .width(210)\n");
      out.write("                            .height(150);\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(input.files[0]);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

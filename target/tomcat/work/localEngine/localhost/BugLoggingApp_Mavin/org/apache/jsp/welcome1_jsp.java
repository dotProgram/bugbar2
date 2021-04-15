package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

 if(session.getAttribute("id")== null){
     response.sendRedirect("Login.jsp");

     } 
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta name=\"author\" content=\"\" />\n");
      out.write("        <title>Static Navigation - SB Admin</title>\n");
      out.write("        <link href=\"css/styles.css\" rel=\"stylesheet\" />\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"sb-topnav navbar navbar-expand navbar-dark bg-dark\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"index2.html\">Bug Trapr</a>\n");
      out.write("            <button class=\"btn btn-link btn-sm order-1 order-lg-0\" id=\"sidebarToggle\" href=\"#\"><i class=\"fas fa-bars\"></i></button>\n");
      out.write("            <!-- Navbar Search-->\n");
      out.write("            <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\">\n");
      out.write("                <div class=\"input-group\">\n");
      out.write("                    <input class=\"form-control\" type=\"text\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\" />\n");
      out.write("                    <div class=\"input-group-append\">\n");
      out.write("                        <button class=\"btn btn-primary\" type=\"button\"><i class=\"fas fa-search\"></i></button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <!-- Navbar-->\n");
      out.write("            <ul class=\"navbar-nav ml-auto ml-md-0\">\n");
      out.write("                <li class=\"nav-item dropdown\">\n");
      out.write("                    <a class=\"nav-link dropdown-toggle\" id=\"userDropdown\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"fas fa-user fa-fw\"></i></a>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Settings</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"#\">Activity Log</a>\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"logout\">Logout</a>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <div id=\"layoutSidenav\">\n");
      out.write("            \n");
      out.write("            <!-- The Side Navigation Menu Starts -->\n");
      out.write("            <div id=\"layoutSidenav_nav\">\n");
      out.write("                <nav class=\"sb-sidenav accordion sb-sidenav-dark\" id=\"sidenavAccordion\">\n");
      out.write("                    <div class=\"sb-sidenav-menu\">\n");
      out.write("                        <div class=\"nav\">\n");
      out.write("                            <div class=\"sb-sidenav-menu-heading\">Core</div>\n");
      out.write("                            <a class=\"nav-link\" href=\"index.html\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-tachometer-alt\"></i></div>\n");
      out.write("                                Dashboard\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"sb-sidenav-menu-heading\">Interface</div>\n");
      out.write("                            <!-- Issues\n");
      out.write("  ================================================== -->\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseLayouts\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div>\n");
      out.write("                                Issues\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"collapseLayouts\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"issues/welcome4.jsp\">Add Issues</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Issues</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Issues</a>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- Mobile Specific Projects\n");
      out.write("  ==================================================         session.getAttribute(\"logged_user_name_role\").equals(\"admin\") ||       -->\n");
      out.write(" ");
 if(session.getAttribute("admin") != null   ){
out.println("<a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#demo\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div> Projects <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"demo\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"layout-static.html\">Add Projects</a> <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Projects</a> </nav> </div>");
     } 
      out.write("\n");
      out.write("<!-- Mobile Specific Projects Above Jsp Will Diplay the Committed code\n");
      out.write("\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#demo\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div>\n");
      out.write("                                Projects\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"demo\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-static.html\">Add Projects</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Projects</a>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("  ==================================================               -->\n");
      out.write("     <!-- Mobile Specific Members                        \n");
      out.write("  ==================================================\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#members\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div>\n");
      out.write("                                Members\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"members\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-static.html\">Add Members</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Members</a>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>                            \n");
      out.write("                             -->\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <!-- Mobile Specific  Projects zz \"fas fa-book-open\"\n");
      out.write("  ================================================== -->\n");
      out.write("                            <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\" aria-expanded=\"false\" aria-controls=\"collapsePages\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-book-open\"></i></div>\n");
      out.write("                                Pages\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"collapsePages\" aria-labelledby=\"headingTwo\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav accordion\" id=\"sidenavAccordionPages\">\n");
      out.write("                                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#pagesCollapseAuth\" aria-expanded=\"false\" aria-controls=\"pagesCollapseAuth\">\n");
      out.write("                                        Authentication\n");
      out.write("                                        <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"collapse\" id=\"pagesCollapseAuth\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordionPages\">\n");
      out.write("                                        <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"login.html\">Login</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"register.html\">Register</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"password.html\">Forgot Password</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("                                    <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#pagesCollapseError\" aria-expanded=\"false\" aria-controls=\"pagesCollapseError\">\n");
      out.write("                                        Error\n");
      out.write("                                        <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"collapse\" id=\"pagesCollapseError\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordionPages\">\n");
      out.write("                                        <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"401.html\">401 Page</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"404.html\">404 Page</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"500.html\">500 Page</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                                 <!-- Mobile Specific  Projects zz \"fas fa-book-open\"\n");
      out.write("  ================================================== -->\n");
 
    if(session.getAttribute("admin") != null ){
    out.println("<div class=\"sb-sidenav-menu-heading\">Management</div> <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#members\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div> Members <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"members\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"layout-static.html\">Add Members</a> <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Members</a> </nav> </div>");
    //  Permissions
    out.println("<a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#members\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div> Permissions <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"members\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"layout-static.html\">Add Members</a> <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Members</a> </nav> </div>");

     } 

      out.write("                        \n");
      out.write("             <!-- Mobile Specific Management Above * Jsp Will Diplay * the Committed code\n");
      out.write("             \n");
      out.write("                            <div class=\"sb-sidenav-menu-heading\">Management</div>\n");
      out.write("                             <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#members\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div>\n");
      out.write("                                Members\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"members\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-static.html\">Add Members</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Members</a>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>      -->\n");
      out.write("                                              <!-- Mobile Specific  Permissions zz \"fas fa-book-open\"\n");
      out.write("  ================================================== -\n");
      out.write("                               \n");
      out.write("                             <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#members\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div>\n");
      out.write("                                Permissions\n");
      out.write("                                <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"collapse\" id=\"members\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\">\n");
      out.write("                                <nav class=\"sb-sidenav-menu-nested nav\">\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-static.html\">Add Members</a>\n");
      out.write("                                    <a class=\"nav-link\" href=\"layout-sidenav-light.html\">View Members</a>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>     ->\n");
      out.write("                                              <!-- Mobile Specific  Projects zz \"fas fa-book-open\"\n");
      out.write("  ================================================== -->\n");
      out.write("                            <a class=\"nav-link\" href=\"tables.html\">\n");
      out.write("                                <div class=\"sb-nav-link-icon\"><i class=\"fas fa-table\"></i></div>\n");
      out.write("                                Tables\n");
      out.write("                            </a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"sb-sidenav-footer\">\n");
      out.write("                        <div class=\"small\">Logged in as: ");
      out.print( session.getAttribute("user_name") );
      out.write(" </div>\n");
      out.write("                        Role: ");
      out.print( session.getAttribute("logged_user_name_role").toString().substring(0, 1).toUpperCase() +session.getAttribute("logged_user_name_role").toString().substring(1) );
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("             \n");
      out.write("             \n");
      out.write("               <!-- The Side Navigation Menu Ends -->\n");
      out.write("            <div id=\"layoutSidenav_content\">\n");
      out.write("                <main>\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <h1 class=\"mt-4\">Static Navigation</h1>\n");
      out.write("                        <ol class=\"breadcrumb mb-4\">\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item active\">Static Navigation</li>\n");
      out.write("                        </ol>\n");
      out.write("                        <div class=\"card mb-4\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <p class=\"mb-0\">\n");
      out.write("                                    This page is an example of using static navigation. By removing the\n");
      out.write("                                    <code>.sb-nav-fixed</code>\n");
      out.write("                                    class from the\n");
      out.write("                                    <code>\n");
      out.write("  <!-- Mobile Specific  Projects zz \"fas fa-book-open\"\n");
      out.write("  \n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/display", out, false);
      out.write("  \n");
      out.write("  ================================================== -->\n");
      out.write("                                  \n");
      out.write("                                </p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div></div>\n");
      out.write("                        <div class=\"card mb-4\"><div class=\"card-body\">When scrolling, the navigation stays at the top of the page. This is the end of the static navigation demo.</div></div>\n");
      out.write("                    </div>\n");
      out.write("                </main>\n");
      out.write("                <footer class=\"py-4 bg-light mt-auto\">\n");
      out.write("                    <div class=\"container-fluid\">\n");
      out.write("                        <div class=\"d-flex align-items-center justify-content-between small\">\n");
      out.write("                            <div class=\"text-muted\">Copyright &copy; Your Website 2020</div>\n");
      out.write("                            <div>\n");
      out.write("                                <a href=\"#\">Privacy Policy</a>\n");
      out.write("                                &middot;\n");
      out.write("                                <a href=\"#\">Terms &amp; Conditions</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

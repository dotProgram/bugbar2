package com.buglogginginmaven.projects;



import com.buglogginginmaven.database.DatabaseConnection;
import com.buglogginginmaven.issues.viewIssues;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.buglogginginmaven.profile.ClientDetails;
    
public class view3 extends HttpServlet  {    

DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
   
     
      @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
       
res.sendRedirect("admin/project.jsp");
}
    
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
                      HttpSession session=req.getSession();  
                    PrintWriter out = res.getWriter();  
                    res.setContentType("text/html"); 
                    out.println("<!DOCTYPE html> <html lang=\"en\"> <head> <meta charset=\"utf-8\" /> <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" /> <meta name=\"description\" content=\"\" /> <meta name=\"author\" content=\"\" /> <title>Static Navigation - SB Admin</title> <link href=\"../css/styles.css\" rel=\"stylesheet\" /> <script src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js\" crossorigin=\"anonymous\"></script> </head> <body> <nav class=\"sb-topnav navbar navbar-expand navbar-dark bg-dark\"> <a class=\"navbar-brand\" href=\"index.html\">Start Bootstrap</a> <button class=\"btn btn-link btn-sm order-1 order-lg-0\" id=\"sidebarToggle\" href=\"#\"><i class=\"fas fa-bars\"></i></button> <!-- Navbar Search--> <form class=\"d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0\"> <div class=\"input-group\"> <input class=\"form-control\" type=\"text\" placeholder=\"Search for...\" aria-label=\"Search\" aria-describedby=\"basic-addon2\" /> <div class=\"input-group-append\"> <button class=\"btn btn-primary\" type=\"button\"><i class=\"fas fa-search\"></i></button> </div> </div> </form> <!-- Navbar--> <ul class=\"navbar-nav ml-auto ml-md-0\"> <li class=\"nav-item dropdown\"> <a class=\"nav-link dropdown-toggle\" id=\"userDropdown\" href=\"#\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"><i class=\"fas fa-user fa-fw\"></i></a> <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"userDropdown\"> <a class=\"dropdown-item\" href=\"#\">Settings</a> <a class=\"dropdown-item\" href=\"#\">Activity Log</a> <div class=\"dropdown-divider\"></div> <a class=\"dropdown-item\" href=\"login.html\">Logout</a> </div> </li> </ul> </nav> <div id=\"layoutSidenav\"> <div id=\"layoutSidenav_nav\"> <nav class=\"sb-sidenav accordion sb-sidenav-dark\" id=\"sidenavAccordion\"> <div class=\"sb-sidenav-menu\"> <div class=\"nav\"> <div class=\"sb-sidenav-menu-heading\">Core</div> <a class=\"nav-link\" href=\"index.html\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-tachometer-alt\"></i></div> Dashboard </a> <div class=\"sb-sidenav-menu-heading\">Interface</div> <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseLayouts\" aria-expanded=\"false\" aria-controls=\"collapseLayouts\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-columns\"></i></div> Layouts <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"collapseLayouts\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordion\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"layout-static.html\">Static Navigation</a> <a class=\"nav-link\" href=\"layout-sidenav-light.html\">Light Sidenav</a> </nav> </div> <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\" aria-expanded=\"false\" aria-controls=\"collapsePages\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-book-open\"></i></div> Pages <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"collapsePages\" aria-labelledby=\"headingTwo\" data-parent=\"#sidenavAccordion\"> <nav class=\"sb-sidenav-menu-nested nav accordion\" id=\"sidenavAccordionPages\"> <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#pagesCollapseAuth\" aria-expanded=\"false\" aria-controls=\"pagesCollapseAuth\"> Authentication <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"pagesCollapseAuth\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordionPages\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"login.html\">Login</a> <a class=\"nav-link\" href=\"register.html\">Register</a> <a class=\"nav-link\" href=\"password.html\">Forgot Password</a> </nav> </div> <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#pagesCollapseError\" aria-expanded=\"false\" aria-controls=\"pagesCollapseError\"> Error <div class=\"sb-sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div> </a> <div class=\"collapse\" id=\"pagesCollapseError\" aria-labelledby=\"headingOne\" data-parent=\"#sidenavAccordionPages\"> <nav class=\"sb-sidenav-menu-nested nav\"> <a class=\"nav-link\" href=\"401.html\">401 Page</a> <a class=\"nav-link\" href=\"404.html\">404 Page</a> <a class=\"nav-link\" href=\"500.html\">500 Page</a> </nav> </div> </nav> </div> <div class=\"sb-sidenav-menu-heading\">Addons</div> <a class=\"nav-link\" href=\"charts.html\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-chart-area\"></i></div> Charts </a> <a class=\"nav-link\" href=\"tables.html\"> <div class=\"sb-nav-link-icon\"><i class=\"fas fa-table\"></i></div> Tables </a> </div> </div> <div class=\"sb-sidenav-footer\"> <div class=\"small\">Logged in as:</div> Start Bootstrap </div> </nav> </div> <div id=\"layoutSidenav_content\"> <main> <div class=\"container-fluid\"> <h1 class=\"mt-4\">Static Navigation</h1> <ol class=\"breadcrumb mb-4\"> <li class=\"breadcrumb-item\"><a href=\"index.html\">Dashboard</a></li> <li class=\"breadcrumb-item active\">Static Navigation</li> </ol> <div class=\"card mb-4\"> <div class=\"card-body\"> <p class=\"mb-0\"> This page is an example of using static navigation. By removing the <code>.sb-nav-fixed</code> class from the"); 
                    //out.println("<html><body>"); 
                  //  out.println("<h3><a href=\"admin/index.jsp\">Back l</a></h3><br>");  
                   String sqlWhereCondQuery =""; 
                    String sqlWhereCondQuery2 = null; 
                    String isSetDelete = req.getParameter("delete");
                    String check_box = req.getParameter("checkbox");
                    ArrayList<String> checkbox_array = new ArrayList<String>();
                   // checkbox_array = req.getParameter("checkbox");
                    checkbox_array.add( req.getParameter("checkbox"));  
                    String multiple_check[]=req.getParameterValues("checkbox"); //get checkbox name value "chk_language" and store in language[] array  

                    //To Check if There is any Delete Requset by thr User
                       if( isSetDelete == null  ){
                   // if( isSetDelete.isEmpty()  ){
                    

                     out.println("isSetDelete is Empty"+" Checkbbox="+check_box); 
                    }
                                                    //TO CHECK IF THERE IS ANY **DELETE REQUSET** BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT --------------------------  STARTS
                                                 
                                                    else if( isSetDelete != null  && multiple_check  != null ){
                                                    out.println(processDeleteRequest(isSetDelete, check_box, multiple_check , out,  checkbox_array) +"</br>"); 
                                                              
                                                    }
            
            //TO CHECK IF THERE IS ANY DELETE REQUSET BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT -------------------------- *ENDS*
         
         
            
           int  LoggedUserId_fetching_from_session = (Integer )session.getAttribute("logged_user_id") ; 
          session.getAttribute("logged_user_id");  
           System.out.println("\n session.GET (\"logged_user_id\" =  "+ (Integer )session.getAttribute("logged_user_id")  +"\n"+LoggedUserId_fetching_from_session);
            
                                   //Importing  Profine Class Starts
                    
                      ClientDetails cd = new ClientDetails();
          try {
             
              ArrayList<String> UsersDetails = new  ArrayList<String>(); // To Derive Users Added By Logged Admin
              ArrayList<String> ProjectDetails = new  ArrayList<String>();  // To Derive Projects Added By Logged Admin
              UsersDetails = cd. admin_or_client_details("project_admin_relationship", "project_uid", LoggedUserId_fetching_from_session);
             
             
             System.out.println("Fetching the Array list Project_uidv   servlet Class \t");
             System.out.println("\n Size of Attaylist =\t"+UsersDetails.size());
             UsersDetails.forEach(name -> System.out.println( "Reterived Unique Project Id Added by "+LoggedUserId_fetching_from_session+" user is : "+name+"\n"));
             
             // Now lets us create the string that we will need to create the WHERE condition in the SELECT SQL Statement
           
             System.out.println("\n Value of Attaylist @ 0 =\n"+UsersDetails.get(0));
             //System.out.println("\n Value of Attaylist @ 1 =\n"+UsersDetails.get(1));
             //System.out.println("\n Value of Attaylist @ 2 =\n"+UsersDetails.get(2));
           
             for(int i = 0; i < UsersDetails.size(); i++ ){
                  System.out.println("\n Inside For Loop i= "+i);
                 sqlWhereCondQuery = UsersDetails.get(i);
                 
                 if(sqlWhereCondQuery2 == null){
                     sqlWhereCondQuery2 =  sqlWhereCondQuery;   }
                 
                 else{
                   sqlWhereCondQuery2 = sqlWhereCondQuery2+"', '"+sqlWhereCondQuery;
                 }
                 
                   System.out.println("\n \n <br> loop array value = "+UsersDetails.get(i));  
             }
             
         
         //  out.println("\n \n <br>WHERE condition in the SELECT SQL Statement ="+sqlWhereCondQuery);  
            System.out.println("\n \n <br>WHERE condition in the SELECT SQL Statement 2 ="+sqlWhereCondQuery2);  
             
             
             
           //  System.out.println("Fetching the Array project_uid details inside servlet Class \t \n");
          //   ProjectDetails = cd. adminAddedProjectsDetails("project_admin_relationship", "project_uid", 11);
            // ProjectDetails.forEach(name -> System.out.println(name+"\n"));
             
             
             
          } catch (ClassNotFoundException | SQLException ex) {
              Logger.getLogger(viewIssues.class.getName()).log(Level.SEVERE, null, ex);
          }
                    //Importing  Profine Class Ends
            
            
            
            
            
            
            
            
            
            
         // TO RETRIEVE DATA OF USER FROM DATABASE          ******** |||||||||||||||||||||||||
         // *****TRY STATEMENT          *************** STARTS********|||||||||||||||||||||||||
                                                    try 
                                                    {  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                           
                           
                                                                        Statement stmt = con.createStatement();  
                                                                     //   ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("select * from project"); 
                                                                        //ResultSet rs = stmt.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery2+"')" );    
                                                                          ResultSet rs = stmt.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery2+"');" ); 
                                                                                System.out.println(" \nselect * from project where project_uid IN ( "+sqlWhereCondQuery2); 
                                                                                System.out.println(" \n select * from project where project_uid IN ('"+sqlWhereCondQuery2+"')\n"); 
                                                                          out.println("<form action=projects method=post target=\"_blank\"> <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                        out.println("<table border=1 width=100% height=50% color=lightgreen>");  
                                                                        //out.println("<tr><th>Select</th><th>Project-- Id</th><th>Project Name</th><th>Project Description</th><th>Project Unique Id</th><tr>");  
                                                                           out.println("<tr><th>Select</th><th>Project-- Id</th><th>Project Name</th><th>Project Description</th><tr>");  
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");           
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                           
                                                                            int id = rs.getInt("id");   
                                                                            

                                                                             out.println("<tr style=\"cursor: pointer;\"  onclick=\"window.location='vad?id="+id+"&request=detail'\" data-href=\"vad\"><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");    
                                                                      //      out.println("<tr style=\"cursor: pointer;\"  onclick=\"window.location='vad?id="+id+"&request=detail'\" data-href=\"vad\"><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
                                                                        }  
                                                                        out.println("</table> </form>");  

                                                                        out.println("</html></body>");  
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     }  //doPost ENDS /\/
     
     
     
     //Blow Class Methords
    private String  processDeleteRequest(String isSetDelete, String check_box, String multiple_check[], PrintWriter out, ArrayList<String> checkbox_array){
       
                                                            out.println("</br>"); 
                                                            out.println(check_box);             
                                                            out.println("</br>");            

                                                                //String language[]=request.getParameterValues("chk_language"); //get checkbox name value "chk_language" and store in language[] array

                                                                for(int i=0;i<multiple_check.length;i++) //apply loop for fecth multiple checkbox value
                                                                {
                                                                  out.println(multiple_check[i]+","); //fetch with comma separate
                                                                
                                                                
                                                                                            try 
                                                                                        {  
                                                                                            Class.forName("com.mysql.jdbc.Driver");  
                                                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                                            Statement stmt = con.createStatement();  
                                                                                            
                                                                                         //   ResultSet rs = stmt.executeUpdate("DELETE FROM user WHERE id="+multiple_check[i]+";");    System.out.println("<br>Real Delete Query Executer Successfully"); 
                                                                                            int rs = stmt.executeUpdate("DELETE FROM project WHERE id="+multiple_check[i]+";");
                                                                                           out.println("DELETE FROM project WHERE id="+multiple_check[i]+";"+" Int RS value = "+rs+"<br>");  
                                                                                            con.close();
                                                                                        }

                                                                                            catch (ClassNotFoundException | SQLException e) 
                                                                                           {  
                                                                                            out.println("Delete error<br>");  
                                                                                            
                                                                                            out.println(e);  
                                                                                        }
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                
                                                                }


                                                              out.println("isSetDelete is not null : Value= "+isSetDelete+" Checkbbox, ArrayList: ="+check_box+","+checkbox_array); 
                                                              
                                                              try 
                                                             {  
                                                                 Class.forName("com.mysql.jdbc.Driver");  
                                                                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                 // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                 Statement stmt = con.createStatement();  
                                                                 ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("<br>Delete Query Executer Successfully"); 
                                                                 con.close();
                                                             }

                                                                 catch (ClassNotFoundException | SQLException e) 
                                                                {  
                                                                 out.println("Delete error");  
                                                                 out.println(e);  
                                                             }
        
        return "processDeleteRequest Sussess";
     
     }
     
     
     
     
 }
package issues;



import database.DatabaseConnection;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
    
public class vad extends HttpServlet  
        
{    
   DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
     
      @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
                     PrintWriter out = res.getWriter();  
                    res.setContentType("text/html");  
                    out.println("<html><body>"); 
                    String request = req.getParameter("request");
                   // int assigned_user_id_int = Integer.parseInt(req.getParameter("assigned_user_id"));
                    
                                                                         int id = Integer.parseInt(req.getParameter("id"));
                                                                         int assigned_user_id = Integer.parseInt(req.getParameter("assigned_user_id")); 
                                                                           //String assigned_user_id = req.getParameter("assigned_user_id");             System.out.println("\n From POST REQUEST: assigned_user_id"+assigned_user_id); 
                                                                            String issue_status = req.getParameter("issue_status");  
                                                                            String issue_title = req.getParameter("issue_title"); 
                                                                            String issue_description = req.getParameter("issue_description");  
                                                                            String platform = req.getParameter("platform");
                                                                            String platform_version = req.getParameter("platform_version");              //System.out.println("While loop"); 
                                                                            String browser = req.getParameter("browser");  
                                                                            String browser_version = req.getParameter("browser_version");
                                                                            String attached_file = req.getParameter("attached_file");
                       
                                                         //OBTAINED USER DETAILS FROM BROWSER 
                                                          System.out.println("\n OBTAINED USER DETAILS FROM BROWSER: ");
                                                          System.out.println("\n id: "+id);
                                                          System.out.println("\n assigned_user_id: "+assigned_user_id);
                                                           System.out.println("\n issue_status: "+issue_status);
                                                            System.out.println("\n issue_title: "+issue_title);
                                                             System.out.println("\n issue_description: "+issue_description);
                                                              System.out.println("\n platform: "+platform);
                                                              System.out.println("\n platform_version: "+platform_version);
                                                          System.out.println("\n browser: "+browser);
                                                           System.out.println("\n browser_version: "+browser_version);
                                                            System.out.println("\n attached_file: "+attached_file);
                                                             System.out.println("\n OBTAINED USER DETAILS FROM BROWSER: --");
                                                           //OBTAINED USER DETAILS FROM BROWSER      
                                                                          


                       if(request.equals("update")){
                          out.println("<h1>Handeling the  update request</h1><br>");  

                         processUpdateRequest(out, id, assigned_user_id, issue_status, issue_title, issue_description, platform, platform_version, browser, browser_version, attached_file);
                        out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
                       res.sendRedirect(" vad?id="+id+"&request=detail");
                        out.println("Update Success! \n");  
           }
          
          else 
          res.sendRedirect("../projects/project.jsp");
          
          
         out.println("</body></html>");  
//res.sendRedirect("projects/project.jsp");
}
    
          @Override
          public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
          
                    PrintWriter out = res.getWriter();  
                    res.setContentType("text/html");  
                    out.println("<html><body>"); 
                    String request = req.getParameter("request");
                    int id = Integer.parseInt(req.getParameter("id"));
                    String project_name = req.getParameter("project_name");
                    String project_description = req.getParameter("project_description"); 
           
           
                     // Create a function to Reterive the Projects associated with the Logged Admin.
           
           
           
           
           
          
           if(request.equals("viewlist")){
             out.println("<h1>Handeling the view request</h1><br>");  
           processViewListRequest(out);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
           
           else if(request.equals("edit")){
             out.println("<h1>Handeling the edit request</h1><br>");  
        
           editDetailRequest(out, id);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
           
            else if(request.equals("detail")){
             out.println("<h1>Handeling the  detail request</h1><br>");  
        
           viewdetailRequest(out, id);
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
          
        
        
           else {
           // Handeling the  Wrong Request</h1>
       // res.sendRedirect("../error.jsp");
           out.println("<h1><br>-----------------------------------------------------------------</h1><br>");  
           }
                                                                          int number=210;  
                                                                         //Switch expression  
                                                                        switch(number){  
                                                                        case 10 -> System.out.println("10");
                                                                         case 20 -> {
                                                                          out.println("<h1>editDetailRequest</h1><br>");
                                                                       //   editDetailRequest(out);
                                                                                              }
                                                                        case 30 -> System.out.println("30");
                                                                        default -> System.out.println("Not in 10, 20 or 30");  
                                                            }
          //Case statements
          //Default case statement
          

             
                    String isSetDelete = req.getParameter("delete");
                    String check_box = req.getParameter("checkbox");
                    ArrayList<String> checkbox_array = new ArrayList<String>();
                   // checkbox_array = req.getParameter("checkbox");
                    checkbox_array.add( req.getParameter("checkbox"));  
                    String multiple_check[]=req.getParameterValues("checkbox"); //get checkbox name value "chk_language" and store in language[] array  

                
                       if( isSetDelete == null  ){
             
                    

                     out.println("isSetDelete is Empty"+" Checkbbox="+check_box); 
                    }
                                                    //TO CHECK IF THERE IS ANY **DELETE REQUSET** BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT --------------------------  STARTS
                                                 
                                                    else if( isSetDelete != null  && multiple_check  != null ){
                                                       out.println(processDeleteRequest(isSetDelete, check_box, multiple_check , out,  checkbox_array) +"</br>"); 
                                                              
                                                    }
            
            //TO CHECK IF THERE IS ANY DELETE REQUSET BY THR USER & IF TRUE PROCEED WITH ELSE STATEMENT -------------------------- *ENDS*
         
         
         // TO RETRIEVE DATA OF USER FROM DATABASE          ******** |||||||||||||||||||||||||
         // *****TRY STATEMENT          *************** STARTS********|||||||||||||||||||||||||
   out.println("</body></html>");                                                  
     }  //doPost ENDS /\/
   
     
     
          private String  processViewListRequest(PrintWriter out){
      try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("select * from project"); 
                                                                        out.println("<form action=projects/view method=post > <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                        out.println("<table border=1 width=100% height=50% color=lightgreen>");  
                                                                        out.println("<tr><td>Select</td><td>Project Id</td><td>Project Name</td><td>Project Description</td><td>Project Unique Id</td><tr>");  
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");              System.out.println("While loop"); 
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                            
                                                                            int id = rs.getInt("id");   
                                                                            out.println("<tr><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
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
     
     return "f";}
     
          private String  viewdetailRequest(PrintWriter out, int id){
         
                                                                    try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from logged_issue where id = " + id +";");    System.out.println("select * from logged_issue"); 
                                                                       
                                                                        while (rs.next()) 
                                                                        {  
                                                                            id = rs.getInt("id");  
                                                                            String assigned_user_id = rs.getString("assigned_user_id");              System.out.println("assigned_user_id"); 
                                                                            String issue_status = rs.getString("issue_status");  
                                                                            String issue_title = rs.getString("issue_title"); 
                                                                            String issue_description = rs.getString("issue_description");  
                                                                            String platform = rs.getString("platform");
                                                                            String platform_version = rs.getString("platform_version");              //System.out.println("While loop"); 
                                                                            String browser = rs.getString("browser");  
                                                                            String browser_version = rs.getString("browser_version");
                                                                            String attached_file = rs.getString("attached_file");
                                                                                 
                                                                            
                                                                         
                                                                                                                                               out.println("<br>");
                                                                            out.println("<style>.left-col{width: 150px; text-align:left; } .right-col{float: right; }</style>");  
                                                                            out.println("<form action=vad method=get > ");  
                                                                            out.println("<input type=\"hidden\" id=\"custId\" name=\"id\" value=" + id +"> ");  
                                                                             out.println("<input type=\"hidden\" id=\"cId\" name=\"request\" value=edit >");  
                                                                            out.println("<table align=\"left\"  border=0 width=80% height=20% color=\"lightgreen\">");  
                                                                            out.println("<tr class=left-col><td></td><td><input class=right-col align=\"right\"  type=\"submit\" value=\"Edit detailss! \" /></td><td></td><tr>");
                                                                            out.println("<tr class=left-col><td>Issue Id</td><td>"+id+"</td><tr>");
                                                                            out.println("<tr class=left-col><td>Issue issue_title</td><td>"+issue_title+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue  issue_status</td><td>"+issue_status+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue assigned_user_id</td><td>"+assigned_user_id+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue issue_description</td><td>"+issue_description+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>issue_description Unique</td><td>"+issue_description+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue  platform_version</td><td>"+platform_version+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue browser</td><td>"+browser+"</td><tr>");  
                                                                            out.println("<tr class=left-col><td>Issue browser_version</td><td>"+browser_version+"</td><tr>"); 
                                                                            out.println("<tr class=left-col><td>Issue attached_file</td><td>"+attached_file+"</td><tr>"); 
                                                                           // out.println("<tr class=left-col><td>Select</td><td></td><tr>");  
                                                                            out.println("</table> </form><br>");  
                                                                            

                                                                             
                                                                         
                                                                        }  
                                                                       
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     
     
          
          
          
          
return "dell"; }
     
          private String  editDetailRequest(PrintWriter out, int id){
          
                                                                 try 
                                                    {  
                                                                        out.println("Inside Method processViewRequest");  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from logged_issue where id = " + id +";");    System.out.println("select * from logged_issue"); 
                                                                       
                                                                        while (rs.next()) 
                                                                        {  
                                                                            id = rs.getInt("id");  
                                                                            String assigned_user_id = rs.getString("assigned_user_id");              System.out.println("assigned_user_id"+assigned_user_id); 
                                                                            String issue_status = rs.getString("issue_status");  
                                                                            String issue_title = rs.getString("issue_title"); 
                                                                            String issue_description = rs.getString("issue_description");  
                                                                            String platform = rs.getString("platform");
                                                                            String platform_version = rs.getString("platform_version");              System.out.println("While loop"); 
                                                                            String browser = rs.getString("browser");  
                                                                            String browser_version = rs.getString("browser_version");
                                                                            String attached_file = rs.getString("attached_file");
                                                                            
                                                                           // int id = rs.getInt("id");   
                                                                                                                                               out.println("<br>");
                                                                            out.println("<style>.left-col{width: 150px; text-align:left; } .right-col{float: right; }</style>");  
                                                                            out.println("<form action=vad method=post > ");  
                                                                            out.println("<table align=\"left\"  border=0 width=80% height=20% color=\"lightgreen\">");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"id\" value=\""+ id +"\"> ");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"request\" value=\"update\"> ");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"issue_status\" value=\"issue_status\"> ");  
                                                                            out.println("<input type=\"hidden\" id=\"id\" name=\"assigned_user_id\" value=\"" + assigned_user_id +"\"> ");  
                                                                            out.println("<tr class=left-col><td></td><td><input class=right-col align=\"right\"  type=\"submit\" value=\"Save \" /></td><td></td><tr>");
                                                                            out.println("<tr class=left-col><td>Project No.</td><td>"+id+"</td><tr>");
                                                                            out.println("<tr class=left-col><td>assigned_user_id Unique</td><td>"+assigned_user_id+"</td><tr>");
                                                                            out.println("<tr class=left-col><td>Project issue_status</td><td>"+issue_status+"</td><tr>");
                                                                            out.println("<tr class=left-col><td>issue_title  Name</td><td><input type=\"text\" name=\"issue_title\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+issue_title+"\"/></td><tr>");  
                                                                            out.println("<tr class=left-col><td>platform  Name</td><td><input type=\"text\" name=\"platform\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+platform+"\"/></td><tr>");  
                                                                            out.println("<tr class=left-col><td>platform_version  Name</td><td><input type=\"text\" name=\"platform_version\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+platform_version+"\"/></td><tr>");  
                                                                            out.println("<tr class=left-col><td>browser  Name</td><td><input type=\"text\" name=\"browser\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+browser+"\"/></td><tr>");  
                                                                            out.println("<tr class=left-col><td>browser_version  Name</td><td><input type=\"text\" name=\"browser_version\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+browser_version+"\"/></td><tr>");  
                                                                            
                                                                           // out.println("<tr class=left-col><td>attached_file  Name</td><td><input type=\"text\" name=\"project_name\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+attached_file+"\"/></td><tr>");  
                                                                           out.println("<tr class=left-col><td>issue issue_description!</td><td><textarea name=\"issue_description\" maxlength=\"1024\" style=\"min-width: 950px ; max-width:950px; min-height: 350px; max-height: 350px;\"/>"+issue_description+"</textarea></td><tr>");  
                                                                         out.println("<tr class=left-col><td>attached_file  Name</td><td><input type=\"file\" name=\"attached_file\" style=\"min-width: 950px ; max-width:950px; maxlength=\"102\" value=\""+attached_file+"\"/></td><tr>");  
                                                                           //out.println("<tr class=left-col><td>Project Members</td><td>"+project_name+"</td><tr>");  
                                                                           // out.println("<tr class=left-col><td>Select</td><td></td><tr>");  
                                                                            out.println("</table> </form>");  
                                                                            

                                                                             
                                                                         
                                                                        }  
                                                                       
                                                                        con.close();  
                                                         }  

                                                    // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                    // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////


                                                        catch (ClassNotFoundException | SQLException e) 
                                                       {  
                                                        out.println("error");  
                                                        out.println(e);  
                                                    }  
     
     
          
          
          
          
return "dell"; }
     
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
                                                                                                                                       
          private String  processUpdateRequest(PrintWriter out, int id,  int assigned_user_id, String issue_status, String issue_title, String issue_description, String platform, String platform_version, String browser, String browser_version, String attached_file ){
                                                    try {
                                                                                    
                                                      
                                                         System.out.println("\n id: "+id);
                                                          System.out.println("\n assigned_user_id: "+assigned_user_id);
                                                           System.out.println("\n issue_status: "+issue_status);
                                                            System.out.println("\n issue_title: "+issue_title);
                                                             System.out.println("\n issue_description: "+issue_description);
                                                              System.out.println("\n platform: "+platform);
                                                              System.out.println("\n platform_version: "+platform_version);
                                                          System.out.println("\n browser: "+browser);
                                                           System.out.println("\n browser_version: "+browser_version);
                                                            System.out.println("\n attached_file: "+attached_file);
                                                             System.out.println("\n out: "+out);
                                      
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        System.out.println("\n  String issue_title , "+issue_title+"   String project_description,  "+issue_description+"  id =  "+id+"" );
                                                                                    System.out.println("\n Inside ISSUE<> processUpdateRequest\n ");
                                                                                    System.out.println("UPDATE try com.mysql.jdbc.Driver com.mysql.jdbc.Driver\n");
                                                                                    System.out.println("\n assigned_user_id: "+assigned_user_id);
                                                                                    Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                                                                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                  //  PreparedStatement ps = con.prepareStatement("update project set (project_name, project_description) values(?,?) where id = " + id +";");  System.out.println("Reached UPDATE PreparedStatement");
                                                                                  PreparedStatement ps = con.prepareStatement("update logged_issue set issue_title = '"+issue_title+"', issue_description = '"+issue_description+"', assigned_user_id = "+assigned_user_id+", platform = '"+platform+"', platform_version = '"+platform_version+"', browser = '"+browser+"', browser_version = '"+browser_version+"', attached_file = '"+attached_file+"', issue_status  = '"+issue_status+"' where id = " +id+";");
                                                                                //    PreparedStatement ps = con.prepareStatement("update logged_issue set issue_title = 'issue_title', issue_description = 'issue_description', assigned_user_id = 73, platform = 'platform', platform_version = 'platform_version', browser = 'browser', browser_version = 'browser_version', attached_file = 'attached_file', issue_status  = 'issue_status' where id = 11;");
                                                                                   System.out.println("Reached UPDATE PreparedStatement ID= "+id);
                                                                                   
                                                                                   
                                                                                   
                                                                                 // ps.setString(1,);
                                                                                  //  ps.setString(1, project_name);
                                                                                    //ps.setString(2, project_description);
                                                                                       //int i = ps.executeUpdate();
                                                                                  try{
                                                                                  ps.executeUpdate();
                                                                                  }
                                                                                      catch (SQLException e2) {
                                                                                    System.out.println("LOL\n"+e2);
                                                                                    out.print("<h2>Issue Update Failure!.</h2>");
                                                                                }
                                                                                    
                                                                                    
                                                                                 //   if (i > 0){
                                                                                       // out.print("<h2>Issue Update Success!.</h2>");}

                                                                                } 
                                                    
                                                                        catch (ClassNotFoundException | SQLException e2) {
                                                                                    System.out.println(e2);
                                                                                    out.print("<h2>Issue Update Failure!.</h2>");
                                                                                }
     
     return "Update Success";
 }}
package com.buglogginginmaven.projects;




import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
import com.buglogginginmaven.database.DatabaseConnection;
    
public class project extends HttpServlet  
        
{    
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
                    PrintWriter out = res.getWriter();  
                    res.setContentType("text/html");  
                    out.println("<html><body>"); 
                  //  out.println("<h3><a href=\"admin/index.jsp\">Back l</a></h3><br>");  
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
         
         
         // TO RETRIEVE DATA OF USER FROM DATABASE          ******** |||||||||||||||||||||||||
         // *****TRY STATEMENT          *************** STARTS********|||||||||||||||||||||||||
                                                    try 
                                                    {  
                                                                        Class.forName("com.mysql.jdbc.Driver");  
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from project");    System.out.println("select * from project"); 
                                                                          out.println("<form action=projects method=post target=\"_blank\"> <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                        out.println("<table border=1 width=100% height=50% color=lightgreen>");  
                                                                        out.println("<tr><th>Select</th><th>Project-- Id</th><th>Project Name</th><th>Project Description</th><th>Project Unique Id</th><tr>");  
                                                                        while (rs.next()) 
                                                                        {  
                                                                           
                                                                            String project_name = rs.getString("project_name");              System.out.println("While loop"); 
                                                                            String project_description = rs.getString("project_description");  
                                                                            String project_uid = rs.getString("project_uid");  
                                                                           
                                                                            int id = rs.getInt("id");   
                                                                            

                                                                             
                                                                            out.println("<tr style=\"cursor: pointer;\"  onclick=\"window.location='vad?id="+id+"&request=detail'\" data-href=\"vad\"><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + project_name + "</td><td>" + project_description + "</td><td>" + project_uid + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
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
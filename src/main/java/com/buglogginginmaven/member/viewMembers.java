package com.buglogginginmaven.member;

import com.buglogginginmaven.database.DatabaseConnection;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
  import com.buglogginginmaven.profile.ClientDetails; 

public class viewMembers extends HttpServlet  
 {    
 DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
     
      @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
       
res.sendRedirect("display");
}
    
     @Override
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
          
          
          
                     String sqlWhereCondQuery =""; 
                     String sqlWhereCondQuery2 = null; 
                     HttpSession session=req.getSession(); 
                     Integer logged_user_id =  (Integer)session.getAttribute("logged_user_id");
                     session.getAttribute("logged_user_name_role");
                         
                     ClientDetails cd = new ClientDetails();
                 // ArrayList<Integer> adminAddedUsers = new  ArrayList<Integer>(); // To Derive Users Added By Logged Admin
                      ArrayList<String> adminAddedUsers = new  ArrayList<String>();
        
                     PrintWriter out = res.getWriter();  
                    
                    
                     try {
                                adminAddedUsers = cd.userID("admin_user_relationship", "userID", "adminID", logged_user_id);
                                out.println("\n"+adminAddedUsers); 
                                
                                for(int i = 0; i < adminAddedUsers.size(); i++ )
                                {
                                           sqlWhereCondQuery = adminAddedUsers.get(i);
                 
                                          if(sqlWhereCondQuery2 == null){
                                            sqlWhereCondQuery2 =  sqlWhereCondQuery;   
                                            }
                 
                                            else{
                                           sqlWhereCondQuery2 = sqlWhereCondQuery2+", "+sqlWhereCondQuery;
                                            }
                 
                                           out.println("\n \n <br> adminAddedUsers are as >< = "+adminAddedUsers.get(i));  
                                }
                             } catch (ClassNotFoundException | SQLException ex) {
                                 Logger.getLogger(viewMembers.class.getName()).log(Level.SEVERE, null, ex);
                             }
                    
                    res.setContentType("text/html");  
                    out.println("Session and User Role  "+logged_user_id+"\t  "+session.getAttribute("logged_user_name_role")); 
                   // out.println("<html><body>"); 
                    
                    out.println("<html><body>"); 
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
                                                                        Class.forName(databaseconnection_driver);    
                                                                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        
                                                                        
                                                                        
                                                                        //ResultSet rs = stmt.executeQuery("select * from user");    System.out.println("select * from user"); 
                                                                        ResultSet rs = stmt.executeQuery("select * from user where id IN ("+sqlWhereCondQuery2+")" );      
                                                                        out.println("<form action=display method=post> <input type=\"submit\" value=\"delete\" name=\"delete\"/>");  
                                                                        out.println("<div class=\"table-responsive\">");  
                                                                        out.println("<table class=\"table\"  border=1 width=50% height=50% color=lightgreen>");  
                                                                        out.println("<tr><th>Select</th><th>id</th><th>firstN</th><th>lName</th><th>userid</th><th>password</th><th>email</th><th>phno</th><tr>");  
                                                                        while (rs.next()) 
                                                                        {  
                                                                            String firstN = rs.getString("firstN");              //System.out.println("While loop"); 
                                                                            String lName = rs.getString("lName");  
                                                                            String userid = rs.getString("userid");  
                                                                            String password = rs.getString("password");  
                                                                            String email = rs.getString("email");  
                                                                            long phno = (long) rs.getDouble("phno");   
                                                                            int id = rs.getInt("id");   
                                                                            out.println("<tr><td><input type=checkbox id=check name=checkbox value="+ id +"></td><td>" + id + "</td><td>" + firstN + "</td><td>" + lName + "</td><td>" + userid + "</td><td>" + password + "</td><td>" + email + "</td><td>" + phno + "</td><td><input type=\"submit\" value=\"Delete\" name=\"delete\"/></td></tr>");   
                                                                        }  
                                                                        out.println("</table> </form>");  
                                                                                      out.println("</div>");  
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
                                                                                            Class.forName(databaseconnection_driver);    
                                                                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                                            // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                                            Statement stmt = con.createStatement();  
                                                                                            
                                                                                         //   ResultSet rs = stmt.executeUpdate("DELETE FROM user WHERE id="+multiple_check[i]+";");    System.out.println("<br>Real Delete Query Executer Successfully"); 
                                                                                            int rs = stmt.executeUpdate("DELETE FROM user WHERE id="+multiple_check[i]+";");
                                                                                           out.println("DELETE FROM user WHERE id="+multiple_check[i]+";"+" Int RS value = "+rs+"<br>");  
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
                                                                 Class.forName(databaseconnection_driver);    
                                                                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                 // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                 Statement stmt = con.createStatement();  
                                                                 ResultSet rs = stmt.executeQuery("select * from user");    System.out.println("<br>Delete Query Executer Successfully"); 
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
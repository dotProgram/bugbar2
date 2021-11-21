package com.buglogginginmaven.demotest;
 

import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.buglogginginmaven.profile.ClientDetails;
import com.buglogginginmaven.database.DatabaseConnection;  

/**
 * Servlet implementation class guru_register
 */
public class login extends HttpServlet {
private static final long serialVersionUID = 1L;
DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 


     @Override   
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    response.sendRedirect("Login.jsp");
    
    }
        @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                                           int Authenticity;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
                                            ClientDetails cd = new ClientDetails();
                                           String html_1 = "<html> <head> <meta charset=\"UTF-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> </head> <body> <div>";
                                           String html_2 = "</div></body></html>";
                   
                                            String par = "Invalid Parameters";
                                            PrintWriter out = response.getWriter( );
                                            
                                            //JUST TO DISPLAY DATA
                                            request.setAttribute("username",username);
                                            request.setAttribute("password",password);


                                                     if(username.isEmpty() || password.isEmpty() ){
                                                     {
                                                             RequestDispatcher rd =   request.getRequestDispatcher("pr/login.jsp");  
                                                          //RequestDispatcher rd2= response.
                                                             request.setAttribute("invalid","inval");
                                                          //rd.forward(request, response);     
                                                             response.sendRedirect("pr/login.jsp");
                                                            }
                                                      }
                                          
                                                     else
                                                    {
                                                    //SRART ELSE IF ALL DORM INPUT ARE FILLED
                                                    HttpSession session=request.getSession();  
                                                    
                                                  //AuthenticityOfUserLoggingIn(username, password, session) Checks if the Client is ADMIN OR A USER
                                                  //Authenticity = 2;
                                                     Authenticity = AuthenticityOfUserLoggingIn(username, password, session);
                                                            System.out.println("\nAuthenticityOfUserLoggingIn= "+Authenticity);
                                                            System.out.println("\n gET SESSION VARIABLE ID = "+session.getAttribute("id")); 
                                                            System.out.println("\n gET SESSION VARIABLE ROLE  = "+session.getAttribute("role"));
                                                            System.out.println("\n gET SESSION VARIABLE user_name  = "+session.getAttribute("user_name")); 
                                                     
                                                                                    if(Authenticity == 1){ 
                                                                             //  session.setAttribute("user","Database Pass");
                                                                                   session.setAttribute("s_name",username+"  <br />This is Session Variable <br />");  
                                                                                   session.setAttribute("role","user");
                                                                                   out.println(html_1);
                                                                                   out.println("</br>Session is :"+session.getAttribute("s_name1"));
                                                                                   out.println("</br><strong>" + username + "</strong>  <br /><strong>" + password + "</strong>  <br /><strong>" + username + "</strong> : <br /><strong>" + password + "</strong> : <br />");
                                                                                   out.println("</br>This is Servlet Login");    
                                                                                   RequestDispatcher req = request.getRequestDispatcher("user.jsp");
                                                                                   //req.forward(request, response);
                                                                                   response.sendRedirect("user.jsp");
                                                                                   //Create aFunction to know the Admin of the User
                                                                                   // Return Admin Id and Admin Name
                                                                                   // Select Admin ID from project admin Relationship where user id = logged session user.
                                                                                   ArrayList<String> UsersDetails = new  ArrayList<String>(); 
                                                         System.out.println("Calling for ,,<<>> admin id opject\n");        
                                                        try {
                                                           // int i__d = (Integer)session.getAttribute("getAttribute");
                                                            UsersDetails = cd. adminID("admin_user_relationship", "adminID", "userID", (Integer)session.getAttribute("logged_user_id_in_session"));
                                                            session.setAttribute("admin_id_of_the_logged_in_user", (String)UsersDetails.get(0));
                                                            System.out.println("Arary @ 0th "+ UsersDetails.get(0));
                                                             System.out.println("Arary @ 0th String "+ (String)UsersDetails.get(0));
                                                            System.out.println("admin_id_of_the_logged_in_user from session"+"'"+ session.getAttribute("admin_id_of_the_logged_in_user"));
                                                        } catch (ClassNotFoundException | SQLException ex) {
                                                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                    
                                                                                     System.out.println("OUTPUTTING THE ADMIN ID OF LOGGED USER"+"'"+UsersDetails+"'\n");                
                                                                                                                        }  


                                                                                    else if(Authenticity == 2){ 

                                                                                  // HttpSession session=request.getSession();  
                                                                                   session.setAttribute("admin","Database Pass");
                                                                                   session.setAttribute("role","admin");
                                                                                   session.setAttribute("s_name",username+"  <br />This is Session Variable <br />"); 
                                                                                   
                                                                                   out.println(html_1);
                                                                                   out.println("</br>This is an Admin account<br>");
                                                                                   out.println("</br>Session is :"+session.getAttribute("s_name1"));
                                                                                   out.println("</br><strong>" + username + "</strong>  <br /><strong>" + password + "</strong>  <br /><strong>" + username + "</strong> : <br /><strong>" + password + "</strong> : <br />");
                                                                                   out.println("</br>This is Servlet Login");    
                                                                                   RequestDispatcher req = request.getRequestDispatcher("welcome2.jsp");
                                                                                   //req.forward(request, response);
                                                                                   response.sendRedirect("welcome2.jsp");
                                                                                                                                 }  


                                                                                     else if(Authenticity == 0) { 
                                                                                    // out.println(html_2);
                                                                                     //request.getRequestDispatcher("Login.html").include(request, response);
                                                                                    // response.sendRedirect("Login.jsp");
                                                                                     System.out.println("Sorry, username or password error!");  
                                                                                 // response.sendRedirect("Login.jsp");
                                                                                     request.setAttribute("auth","invalid");
                                                                                     RequestDispatcher rd =   request.getRequestDispatcher("Login.jsp");  

                                                                                   rd.forward(request, response);     

                                                                                                                                } 
                                                   
                                                    }//ENDS ELSE IF ALL DORM INPUT ARE FILLED
	}



private int  AuthenticityOfUserLoggingIn(String userIdDataEntered, String userIdPasswordEntered, HttpSession session ){

    String password1=null;
    int ret = 0;
    int id=0 ;
    String role_of_the_logged_user = "ggg", userid = null, password = null;
 
                                                try 
                                                    {  
                                                                        Class.forName(databaseconnection_driver); 
                                                                        Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                             System.out.println("Reached DriverManager "+databaseconnection_url_db); 
                                                                        // Here dsnname- mydsn,user id- system(for oracle 10g),password is pintu.  
                                                                        Statement stmt = con.createStatement();  
                                                                        ResultSet rs = stmt.executeQuery("select * from user where userid ="+"'"+userIdDataEntered+"';");    System.out.println("\n databaseconnection_url_db"+databaseconnection_url_db+"select * from user where userid =="+"'"+userIdDataEntered+"';");
                                                                       
                                                                       do
                                                                        {   rs.next();
                                                                             id = rs.getInt("id");  
                                                                            userid = rs.getString("userid");  
                                                                            password = rs.getString("password");
                                                                            System.out.println("Boyo While Role"+"'"+rs.getString("role")+"'\n");
                                                                           role_of_the_logged_user = rs.getString("role");    
                                                                            password1 =password;
                                                                            System.out.println("Password retrived"+"'"+password+"';");
                                                                            System.out.println("Password password1"+"'"+password1+"';");
                                                                            System.out.println("Password userIdPasswordEntered"+"'"+userIdPasswordEntered+"'; \n");
                                                                       
                                                                           
                                                                        }   while(false);
                                                                          
                                                                           
                                                                                                if(userIdPasswordEntered.equals(password1)){
                                                                                                //To Retrieve if USER IS ADMIN
                                                                                                if( rs.getString("role").equals("admin")){
                                                                                                  
                                                                                                    System.out.println("Boyo Role"+"'"+role_of_the_logged_user+"'\n"); 
                                                                                                }
                                                                                                 //System.out.println("\n >><< ROLE OF THE USER >><<:"+"'"+role_of_the_logged_user+"'\n");
                                                                                             //    System.out.println("\n  2nd Time >><< ROLE OF THE USER >><<:"+"'"+role_of_the_logged_user+"'\n");
                                                                                                if(role_of_the_logged_user.equals("admin") ){
                                                                                                
                                                                                                System.out.println("\n role_of_the_logged_user.equals = "+role_of_the_logged_user+"  id is :"+id+" AND user_name :"+userid); 
                                                                                                session.setAttribute("user_name", userid);
                                                                                                session.setAttribute("id",id);
                                                                                                session.setAttribute("logged_user_id", id);
                                                                                                session.setAttribute("logged_admin_id_in_session", id);
                                                                                                session.setAttribute("logged_user_name_role", "admin");
                                                                                                 ret = 2;
                                                                                                 
                                                                                                }
                                                                                                
                                                                                                else{
                                                                                                    System.out.println("\n if_user_is_admin. NOT FOUND value = "+role_of_the_logged_user+"   id is"+id+" AND user_name :"+userid);
                                                                                                     session.setAttribute("user_name", userid);
                                                                                                     session.setAttribute("id",id);
                                                                                                     session.setAttribute("logged_user_id",id);
                                                                                                     session.setAttribute("logged_user_id_in_session", id);
                                                                                                     session.setAttribute("logged_user_name_role", "user");
                                                                                                    ret = 1;
                                                                                                    
                                                                                                }
                                                                                                System.out.println("password match   ret set = 1"); 
                                                                                                
                                                                                                 
                                                                                                }
                                                                      
                                                                          con.close();  
                                                         }  

                                                                                // TO RETRIVE DATA OF USER FROM DATABASE               |||||||||||||||||||||||||\\\\\
                                                                                // TRY STATEMENT ***************ENDS                          |||||||||||||||||||||||||/////
                                                     catch (ClassNotFoundException | SQLException e) 
                                                      {     
                                                       System.out.println(e);  
                                                      }  
                                                
            return ret;
           
     




}





}//while
  
                
		 
 
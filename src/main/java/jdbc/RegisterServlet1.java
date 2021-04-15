package jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
 import profile.ClientDetails;

 



public class RegisterServlet1 extends HttpServlet {
    
DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
    
  
    
    
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          ResultSet rs ;
        System.out.println("Inside doPOST");
 
        response.setContentType("text/html");
        HttpSession session=request.getSession();  
        
        try (PrintWriter out = response.getWriter()) {
        
            String userType ="user";
            String firstN = request.getParameter("firstN");
            String lName = request.getParameter("lName");
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phno_String = request.getParameter("phno");
            int phno = Integer.parseInt(phno_String); 
            
            try {
                System.out.println("Inside try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                Class.forName("com.mysql.jdbc.Driver");                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                PreparedStatement ps = con.prepareStatement("insert into user (firstN,lName,userid,password,email,phno,role) values(?,?,?,?,?,?,?);");  System.out.println("Reached PreparedStatement");
                PreparedStatement retUserID = con.prepareStatement("select id from user where email ='"+email+"';");
                                //PreparedStatement admin_user_relationship = con.prepareStatement("select id from ");
             // ps.setString(1,);
                ps.setString(1, firstN);
                ps.setString(2, lName);
                ps.setString(3, userid);
                ps.setString(4, password);
                ps.setString(5, email);
                ps.setString(7, userType);
                    ps.setInt(6, phno);
                int i = ps.executeUpdate();
                
                
                
                
                System.out.println("logged_user_id "+session.getAttribute("logged_user_id"));
                 System. out.println("logged_user_name_role "+session.getAttribute("logged_user_name_role"));
                  
                if (i > 0){
                  rs = retUserID.executeQuery();  
                  rs.next();
                 Integer member_id = rs.getInt("id");   //The Registered ID By the Request 
                 member_id.toString();
                 System.out.print("<h2>The Registered ID By the Request </h2> = || "+member_id);
                 out.print("<h2>You are successfully registered...</h2>\n Now Adding Admin User REl");
                ClientDetails cd2 = new ClientDetails();
                  System.out.println("Returned ID is \t haha");
                                                                                                               if(session.getAttribute("logged_user_name_role").equals("admin")){
                                                                                                                   System.out.println("Inside IF");
                                                                                                                    String logged_user_id="";
                                                                                              try{ 
                                                                                                     // Now The Project is Added Successfully << Adding Project and Admin Association>>  project_adminowner
                                                                                                        PreparedStatement admin_user_relationship = con.prepareStatement("insert into admin_user_relationship (adminID, userID) values(?,?)");  
                                                                                                        System.out.println("\n Reached PreparedStatement OF NESTED TRY \n << admin_user_relationship>>  admin_user_relationship");
                                                                                                    //  admin_user_relationship.setString(1, uuid.toString());
                                                                                                  //    admin_user_relationship.setInt(2, sessionUserID);   
                                                                                                  
                                                                                                         logged_user_id = (String)session.getAttribute("logged_user_id").toString();
                                                                                                       //String logged_user_id = (String)session.getAttribute("logged_user_id");
                                                                                                        System.out.println(logged_user_id);
                                                                                                        admin_user_relationship.setString(1, logged_user_id );
                                                                                                        admin_user_relationship.setString(2, member_id.toString());   
                                                                                             //            int reg_user = cd2.clientID("admin_user_relationship", "adminID"," userID", "adminIDValue", "userIDValue");
                                                                                                        
                                                                                                        
                                                                                                       
                                                                                                            if(admin_user_relationship.executeUpdate() >= 1)
                                                                                                           System.out.println("\n insert into Admin User Rel = SUCCESS \n Id= "+session.getAttribute("logged_user_id"));
                                                                                              }
                                                                                                        
                                                                                                            catch (SQLException e2) {
                                                                                                            System.out.println("\n"+e2);
                                                                                                                        }
                                                                                              
                                                                                                               }
                  
                  
                  
                  
                  
                
               //  System.out.println(returnedID);
                  con.close();  
                
                 } 
                                                                                                               
        }
            catch (ClassNotFoundException | SQLException e2) {
                System.out.println(e2);
            }
 
}
}
}

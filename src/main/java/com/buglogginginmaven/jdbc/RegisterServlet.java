package com.buglogginginmaven.jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.buglogginginmaven.database.DatabaseConnection;
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
import java.sql.SQLException;
 

 



public class RegisterServlet extends HttpServlet {
    
    int count_=0 ;
    DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
  
    
    
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside doPOST");
        
         PrintWriter out = response.getWriter();
       response.setContentType("text/html");  
       
//       HttpSession session=request.getSession();  
//        session.setAttribute("username","Windows XP");
        
        
   //    /*
//                if(false ){
//                System.out.println("count = " +count_);
//
//                this.count_= 0;
//                session.invalidate();
//                 response.sendRedirect("db");
//
//                }

//  */
 System.out.println("count outside if= " +count_);
      
        
        try  {
        
             String userType ="admin";
            String firstN = request.getParameter("firstN");
            String lName = request.getParameter("lName");
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phno_String = request.getParameter("phno");
            int phno = Integer.parseInt(phno_String); 
            
            try {
                System.out.println("Inside try com.mysql.jdbc.Driver com.mysql.jdbc.Driver");
                Class.forName(databaseconnection_driver);                                                                                                                                                                 System.out.println("Reached com.mysql.jdbc.Driver"); 
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                PreparedStatement ps = con.prepareStatement("insert into user (firstN,lName,userid,password,email,phno,role) values(?,?,?,?,?,?,?)");  System.out.println("Reached PreparedStatement");
                
             // ps.setString(1,);
                               ps.setString(1, firstN);
                ps.setString(2, lName);
                ps.setString(3, userid);
                ps.setString(4, password);
                ps.setString(5, email);
                ps.setString(7, userType);
                 ps.setInt(6, phno);                                                                                                                                                                                          System.out.println("Reached ps.setString(6, phno");
                
                int i = ps.executeUpdate();
                if (i > 0){
                    count_++;
                    out.print("<h2>count = "+count_+++ " You are successfully registered...</h2>");
                     System.out.println("Query exrecuter");
                     
                }
           con.close();       
            } catch (ClassNotFoundException | SQLException e2) {
                System.out.println(e2);
                out.print(e2);
            }
  
}
        catch(NumberFormatException e2){
              out.print("E2 Exception "+e2);
        }
        
     
}
}
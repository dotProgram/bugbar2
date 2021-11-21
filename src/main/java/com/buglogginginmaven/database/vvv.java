/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buglogginginmaven.database;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.buglogginginmaven.database.DatabaseConnection;



public class vvv extends HttpServlet {
    
    DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url = databaseconnection_obj.databaseconnection_url; 
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db; 
String databaseconnection_database = databaseconnection_obj.databaseconnection_database; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          DatabaseConnection databaseconnection_obj = new DatabaseConnection();

                  response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
        
        
        


        
        
        

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet vvv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>databaseconnection_driver</h1>:" +           databaseconnection_obj.databaseconnection_driver + "\n");
            out.println("<h1>databaseconnection_url</h1>:" +           databaseconnection_obj.databaseconnection_url + "\n");
                       out.println("<h1>databaseconnection_database</h1>:" +           databaseconnection_obj.databaseconnection_database + "\n");
           out.println("<h1>databaseconnection_username</h1>:" +           databaseconnection_obj.databaseconnection_username + "\n");
            out.println("<h1>databaseconnection_password</h1>:" +           databaseconnection_obj.databaseconnection_password + "\n");
        out.println("<h1>databaseconnection_string </h1>= " +           databaseconnection_obj.databaseconnection_string + "\n");
              out.println("jdbc:mysql://localhost:3306/servlet, root, ");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

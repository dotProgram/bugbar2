/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buglogginginmaven.profile;
import com.buglogginginmaven.database.DatabaseConnection;
import java.io.*;  
import jakarta.servlet.*;  
import jakarta.servlet.http.*;  
import java.sql.*;  
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ClientDetails {
DatabaseConnection databaseconnection_obj = new DatabaseConnection();
String databaseconnection_driver = databaseconnection_obj.databaseconnection_driver;
String databaseconnection_url_db = databaseconnection_obj.databaseconnection_url_db;
String databaseconnection_password = databaseconnection_obj.databaseconnection_password; 
String databaseconnection_username = databaseconnection_obj.databaseconnection_username; 
    
    
   public void ClientDetail(String caller ){
    System.out.println("Client is called by "+caller); 
    
    }
    public ArrayList<String> adminAddedUsersDetails(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
        
        
        
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where id="+adminID+" ;");    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                          String email = rs.getString("email");  
//                                                                          long phno = (long) rs.getDouble("phno");   
//                                                                          int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                            System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                            System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
    
    
    
        public ArrayList<String> adminAddedProjectsDetails(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         //ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where project_adminowner="+adminID+" || id = 115");    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where project_adminowner="+adminID+";");  
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
      

       public ArrayList<String> admin_or_client_details(String database_table, String table_coulmn, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where project_adminowner = "+adminID);    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
       
       //Over Loading
       
        public ArrayList<String> admin_or_client_details(String database_table, String table_coulmn,  String condition, int adminID) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();  
                                                                         ResultSet rs = stmt.executeQuery("select "+table_coulmn+" from "+database_table+" where "+condition+" = "+adminID);    System.out.println("select "+table_coulmn+" from "+database_table+" where id="+adminID+" || id = 18"); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                            String requestedColumn = rs.getString(table_coulmn);  
                                                                            UsersDetails.add(requestedColumn);
                                                                           
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+table_coulmn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array = "+UsersDetails+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return UsersDetails;
    }
       
       // ENDS

        
        public int clientID(String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        int idReturned=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getInt("id"); 
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+idReturned+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned;
    }
        
        public int adminID(String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         
                                                                         System.out.println("The Query was Executed as");
                                                                         System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';"); 
                                                                         
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        String idReturned="0";
                                                                        int idReturned_int=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getString("adminID"); 
                                                                            idReturned_int=Integer.parseInt(idReturned);  
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n Result ID of the USER LOGGED INNNNNNNN "+idReturned_int+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned_int;
    }
        
        
        
        
        
        
        /*  public int clientID(String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        int idReturned=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getInt("id"); 
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+idReturned+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned;
    }
    */
        
        public  ArrayList<String>  userID(String database_table, String getThisColumn, String whereParameter, int whereParametervalue) throws ClassNotFoundException, SQLException{
    ArrayList<String> userID  = new  ArrayList<String>();
                                                                         try{
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord ArrayList<String> Invoked"); 
                                                                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';"); 
                                                                           System.out.println("~******************************************"); 
                                                                         
                                                                         
                                                                        int i=0;
                                                                        String fff="";
                                                                        //Integer i_n_t = new Integer();
                                                                        
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                              fff = rs.getString("userID");
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            
                                                                         //   Integer num = new Integer();
                                                                                userID.add(fff) ;
                                                                                        //=  (Integer)rs.getInt("id");
                                                                              // String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+userID+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         
                                                                     }
                                                                      
       catch (ClassNotFoundException | SQLException ex)  {
 System.out.println("\n Exception= "+ex ); 
}
      return userID;}
        
                public  ArrayList<String>  userID_int(String database_table, String getThisColumn, String whereParameter, int whereParametervalue) throws ClassNotFoundException, SQLException{
    ArrayList<String> userID  = new  ArrayList<String>();
                                                                         try{
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue+";");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord ArrayList<String> Invoked"); 
                                                                         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';"); 
                                                                           System.out.println("~******************************************"); 
                                                                         
                                                                         
                                                                        int i=0;
                                                                        String fff="";
                                                                        //Integer i_n_t = new Integer();
                                                                        
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                              fff = rs.getString("userID");
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            
                                                                         //   Integer num = new Integer();
                                                                                userID.add(fff) ;
                                                                                        //=  (Integer)rs.getInt("id");
                                                                              // String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );

                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+userID+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
  System.out.println("~******************************************"); 
  System.out.println("~*******************Arraay List ********************" +userID); 
  System.out.println("~******************************************"); 
                                                                         
                                                                     }
                                                                      
       catch (ClassNotFoundException | SQLException ex)  {
 System.out.println("\n Exception= "+ex ); 
}
      return userID;}
      
    
   public  ArrayList<String>  adminID(String database_table, String getThisColumn, String whereParameter, Integer whereParametervalue) throws ClassNotFoundException, SQLException{
    ArrayList<String> userID  = new  ArrayList<String>();
                                                                         try{
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet 4 adminID"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is adminID Class Methord"); 
                                                                         
                                                                         
                                                                        int i=0;
                                                                        String fff="";
                                                                        //Integer i_n_t = new Integer();
                                                                        
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
                                                                              fff = rs.getString("adminID");
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            
                                                                         //   Integer num = new Integer();
                                                                                userID.add(fff) ;
                                                                                        //=  (Integer)rs.getInt("id");
                                                                            //   String email = rs.getString("email");  
//                                                                           
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+userID+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         
                                                                     }
                                                                      
       catch (ClassNotFoundException | SQLException ex)  {
 System.out.println("\n Exception= "+ex ); 
}
      return userID;}
            
        
        
        public int insertIntoTable(String database_table, String getThisColumn, String whereParameter, String whereParametervalue, String value2) throws ClassNotFoundException, SQLException{
    
                                                                         
                                                                         Class.forName(databaseconnection_driver);  
                                                                         Connection con = DriverManager.getConnection(databaseconnection_url_db ,databaseconnection_username, databaseconnection_password );                                                            System.out.println("Reached DriverManager  jdbc:mysql://localhost:3306/servlet"); 
                                                                         Statement stmt = con.createStatement();
                                                                          System.out.println("insert "+getThisColumn+" from "+database_table+" where "+whereParameter+" = "+whereParametervalue); 
                                                                         ResultSet rs = stmt.executeQuery("select "+getThisColumn+" from "+database_table+" where "+whereParameter+" = '"+whereParametervalue+"';");    //System.out.println("select "+getThisColumn+" from "+database_table+" where project_adminowner="+whereParameter); 
                                                                         System.out.println("This is ClientDetails Class Methord"); 
                                                                         
                                                                         ArrayList<String> UsersDetails  = new  ArrayList<String>();
                                                                        int i=0;
                                                                        int idReturned=0;
                                                                         while (rs.next()) 
                                                                        {  
                                                                              i++;
//                                                                            String requestedColumn = rs.getString(getThisColumn);  
//                                                                            UsersDetails.add(requestedColumn);
                                                                            idReturned = rs.getInt("id"); 
//                                                                        String email = rs.getString("email");  
//                                                                            long phno = (long) rs.getDouble("phno");   
//                                                                            int id = rs.getInt("id");   
//                                                                          System.out.println("\n This is ClientDetails Class Methord; User ID = "+adminID+" & Password = "+password );
                                                                        System.out.println("\n database_table = "+database_table+" & table_coulmn = "+getThisColumn ); 
                                                                        System.out.println("\n ArrayList<String> UsersDetails Fetching Array The ID is= "+idReturned+" & Loop no = "+i ); 
                                                                        }  
  con.close();  
                                                                         return idReturned;
    }
}

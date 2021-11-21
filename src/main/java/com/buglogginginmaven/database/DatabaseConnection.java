/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.buglogginginmaven.database;

public class DatabaseConnection {

 //Remote Server Database   
  /*    
public String databaseconnection_driver = "com.mysql.cj.jdbc.Driver"; 
public String databaseconnection_url = "jdbc:mysql://bj9fr60lhi3jqcexrp4o-mysql.services.clever-cloud.com/"; 
public String databaseconnection_url_db = "jdbc:mysql://bj9fr60lhi3jqcexrp4o-mysql.services.clever-cloud.com:3306/bj9fr60lhi3jqcexrp4o"; 
public String databaseconnection_database = "bj9fr60lhi3jqcexrp4o"; 
public String databaseconnection_username = "uozzffulm51oaapy"; 
public String databaseconnection_password = "uhgtC5fENZkj2THastVo"; 
     */     
  
  /*       
 //Remote Server Database   

public String databaseconnection_driver = "com.mysql.cj.jdbc.Driver"; 
public String databaseconnection_url = "jdbc:mysql://remotemysql.com/"; 
public String databaseconnection_url_db = "jdbc:mysql://remotemysql.com:3306/28zxOcV0ik"; 
public String databaseconnection_database = "28zxOcV0ik"; 
public String databaseconnection_username = "28zxOcV0ik"; 
public String databaseconnection_password = "LJkWomyi2C"; 
*/

  /*   */
//Local Server Database       
public String databaseconnection_driver = "com.mysql.cj.jdbc.Driver"; 
public String databaseconnection_url = "jdbc:mysql://localhost:3306/"; 
public String databaseconnection_url_db = "jdbc:mysql://localhost:3306/servlet"; 
public String databaseconnection_database = "servlet"; 
public String databaseconnection_username = "root"; 
public String databaseconnection_password = ""; 




//public String databaseconnection_string = databaseconnection_url+databaseconnection_database+", "+databaseconnection_username+","+databaseconnection_password; 
public String databaseconnection_string = databaseconnection_url+databaseconnection_database+","+databaseconnection_username+","; 
//public String databaseconnection_connection = db_url+"/"+db_name+"/"+"/"+db_username+"/"+db_password; 
}

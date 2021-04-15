/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

public class DatabaseConnection {
    
public String databaseconnection_driver = "com.mysql.jdbc.Driver"; 
public String databaseconnection_url = "jdbc:mysql://localhost:3306/"; 
public String databaseconnection_url_db = "jdbc:mysql://localhost:3306/servlet"; 
public String databaseconnection_database = "servlet"; 
public String databaseconnection_username = "root"; 
public String databaseconnection_password = ""; 
//public String databaseconnection_string = databaseconnection_url+databaseconnection_database+", "+databaseconnection_username+","+databaseconnection_password; 
public String databaseconnection_string = databaseconnection_url+databaseconnection_database+","+databaseconnection_username+","; 
//public String databaseconnection_connection = db_url+"/"+db_name+"/"+"/"+db_username+"/"+db_password; 
}

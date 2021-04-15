<%-- 
    Document   : addProject
    Created on : 05-Mar-2021, 1:40:20 pm
    Author     : Lenovo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.logging.Level" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="profile.ClientDetails" %>


<% 
      int  LoggedUserId_fetching_from_session;
     if(session.getAttribute("logged_user_name_role") == null && session.getAttribute("logged_user_id") == null){
     response.sendRedirect("../Login.jsp");
      }


     
 ClientDetails cd = new  ClientDetails(); 
cd.ClientDetail("Issue dot jsp");

%>

<%! ArrayList<String> IssueDetails_Array = new  ArrayList<String>(); 
int adminOfLoggedUser;
int adminOfLoggedUser_string;
 ArrayList<String> adminAddedUsers = new  ArrayList<String>();
String sqlWhereCondQuery =""; 
String sqlWhereCondQuery2 = null; 
/*  
private String retrieve(int LoggedUserId_fetching_from_session, ClientDetails cd){
          //System.out.println("\n Logged Client is  <ADmin> = "+LoggedUserId_fetching_from_session ); 
 ClientDetails cd2 = new  ClientDetails(); 
                                                                                            IssueDetails_Array = cd2.adminAddedProjectsDetails("project_admin_relationship", "project_uid", LoggedUserId_fetching_from_session);
                                                                                           
                                                                                             for(int i = 0; i < IssueDetails_Array.size(); i++ ){
                                                                                                    sqlWhereCondQuery = IssueDetails_Array.get(i);
                                                                                                   if(sqlWhereCondQuery2 == null){
                                                                                                                  sqlWhereCondQuery2 =  sqlWhereCondQuery;   }
                                                                                                    else{
                                                                                                                 sqlWhereCondQuery2 = sqlWhereCondQuery2+"', '"+sqlWhereCondQuery;
                                                                                                             }  // out.println("\n \n <br> loop array value = "+IssueDetails_Array.get(i));  
                                                                                              }
                                                                                System.out.println("\n Executing Query = "+sqlWhereCondQuery2 );  

                                                                return sqlWhereCondQuery2;

                                                                            }

  */
%>
<%ResultSet resultset =null; ResultSet resultset2 =null;%>
 <%
                                                                                     
                                                                                        try{
                                                                     LoggedUserId_fetching_from_session = (int)session.getAttribute("logged_user_id") ;                          
                                                                  Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                                 //Class.forName("com.mysql.jdbc.Driver"); 
                                                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
                                                                 //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 
                                                                   Statement statement = connection.createStatement() ;
                                                                   Statement statement2 = connection.createStatement() ;
                                                                    resultset =statement.executeQuery("select * from user") ;
                                                                   
                                                                   
                                                                //   String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
                                                                  // Will check if the Admin Is Logged or The User and fetch the Project List Accordingly.
                                                                  if(session.getAttribute("logged_user_name_role").equals("user")){
                                                                                           System.out.println("Logged Client is  USER");  
                                                                                        //Find the Admin of the USER and Accordingly dervice Projects Added by the Admin
                                                                                        // LoggedUserId_fetching_from_session
                                                                                            int sessionIduser= (int)LoggedUserId_fetching_from_session;
                                                                                            adminOfLoggedUser = cd.adminID("admin_user_relationship", "adminID","userID", String.valueOf(LoggedUserId_fetching_from_session)  );

                                                                                            System.out.println("\n Finding the Admin of the USER = "+String.valueOf(LoggedUserId_fetching_from_session)); 
                                                                                            System.out.println("\n Reterived the Admin = "+String.valueOf(LoggedUserId_fetching_from_session)); 
                                                                                     //   System.out.println("\n >><< Reterived the Function Returns = "+retrieve(LoggedUserId_fetching_from_session, cd)); 
                                                                                                  
                                                                                         
                                                                                                IssueDetails_Array = cd.adminAddedProjectsDetails("project_admin_relationship", "project_uid", adminOfLoggedUser);
                                                                                                                   for(int i = 0; i < IssueDetails_Array.size(); i++ ){
                                                                                                                            sqlWhereCondQuery = IssueDetails_Array.get(i);
                                                                                                                           if(sqlWhereCondQuery2 == null){
                                                                                                                                          sqlWhereCondQuery2 =  sqlWhereCondQuery;   }
                                                                                                                            else{
                                                                                                                                         sqlWhereCondQuery2 = sqlWhereCondQuery2+"', '"+sqlWhereCondQuery;
                                                                                                                                     }  // out.println("\n \n <br> loop array value = "+IssueDetails_Array.get(i));  
                                                                                                                      }
                                                                                              
                                                                                                                      System.out.println("\n The Where Query Becaomes As = "+String.valueOf(sqlWhereCondQuery2)); 
                                                                                                                      
                                                                                  //resultset2 =statement2.executeQuery("select * from users where userID IN ('"+sqlWhereCondQuery2+"')" ) ;
                                                                                     resultset2 =statement2.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery2+"')" );  
                                                                                           

                                                                                 // resultset2 =statement2.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery2+"')" ); 
                                                                                                                }//If User Ends
                                                                  
                                                                  
                                                                  
                                                                 // session.getAttribute("logged_user_name_role").equals("admin")
                                                                  
                                                                           else { //If the logged user is ADMIN
                                                                  System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~ <ADmin> = "+LoggedUserId_fetching_from_session ); 
                                                                                            System.out.println("\n Logged Client is  <ADmin> = "+LoggedUserId_fetching_from_session ); 
                                                                                            IssueDetails_Array = cd.adminAddedProjectsDetails("project_admin_relationship", "project_uid", LoggedUserId_fetching_from_session);
                                                                                           
                                                                                             for(int i = 0; i < IssueDetails_Array.size(); i++ ){
                                                                                                    sqlWhereCondQuery = IssueDetails_Array.get(i);
                                                                                                   if(sqlWhereCondQuery2 == null){
                                                                                                                  sqlWhereCondQuery2 =  sqlWhereCondQuery;   }
                                                                                                    else{
                                                                                                                 sqlWhereCondQuery2 = sqlWhereCondQuery2+"', '"+sqlWhereCondQuery;
                                                                                                             }  // out.println("\n \n <br> loop array value = "+IssueDetails_Array.get(i));  
                                                                                              }
                                                                                System.out.println("\n Executing Query = "+sqlWhereCondQuery2 );           
                                                                                resultset2 =statement2.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery2+"')" );  
                                                                   
                                                                  }
                                                                 // 
                                                                   
                                                                   
                                                                   String first_name, last_name, concat, ids, project_name;
                                                                   int id;

                                                                                %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Issue</title>
    </head>
    <body bgcolor="steelblue">
        <%    System.out.println("\nRetreivid UID od project "+IssueDetails_Array );  %>
                <%=IssueDetails_Array  %>
        <h1>Add Issue Monkey</h1>
        <div align="center" style='margin-top: 1%; height:550px; background-color: #f8f9fa;'">
<h1 align="center" > Issue Details</h1>
<form action="LogIssue" method="post" >
			<table style="with: 50%">
			
					<tr><td></td>
                                                                                                                   <td><% try{
                                                                                                                                if(request.getAttribute("invalid")!= null && request.getAttribute("invalid").toString().equals("inval")){
                                                                                                                                   out.println("<span style='color:red;'>");
                                                                                                                                    out.println("Empty issue_title or issue_description");
                                                                                                                                    out.println("</span>");
                                                                                                                                }

                                                                                                                                    else if(  request.getAttribute("auth") != null && request.getAttribute("auth").toString().equals("invalid")){
                                                                                                                                   out.println("<span style='color:red;'>");
                                                                                                                                    out.println("Invalid Username or Password");
                                                                                                                                    out.println("</span>");
                                                                                                                                 }
                                                                                                                                                                    }
                                                                                                                            finally{}
                                                                                                                            %>
                                                                                                             </td></tr>	
                                                                                                                <tr>
                                                                                                                                                        <td>Project </td>
                                                                                                                                                        
                                                                                                                                                                                    <th align="left" > 
                                                                                                                    <select  name="issue_project">
                                                                                                                                    <%  while(resultset2.next()){ 
                                                                                                                                                    //id =  resultset.getInt(1);  
                                                                                                                                                    //ids =  resultset2.getString(1);  
                                                                                                                                                    project_name = resultset2.getString(2);
                                                                                                                                                    System.out.println("\n project_name: "+project_name);
                                                                                                                                                    //last_name = resultset2.getString(3);
                                                                                                                                                   // concat = first_name + " "+ last_name;
                                                                                                                                                   // resultset.getString(6)
                                                                                                                                                    %>
                                                                                                                                                        <option name="project_name" value="<%= project_name %>"><%= project_name %></option>
                                                                                                                                        <% } %>
                                                                                                                      </select> 
                                        </th>
                                                                                                                                                                                                                              
                                                                                                            </tr>
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            
                                                                                                            <tr>
					<td>Issue Title</td>
					<td><input type="text" name="issue_title" style="width:550px;" /></td>
                                                                                                            </tr>
                                                    
                                                                                     <tr>
				<td>Assign to</td>
                                                        <%
                                                            /*
                                                                try{
                                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                                 //Class.forName("com.mysql.jdbc.Driver"); 
                                                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
                                                                 //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", ""); 
                                                                   Statement statement = connection.createStatement() ;

                                                                   resultset =statement.executeQuery("select * from user") ;
                                                                   String first_name, last_name, concat, ids;
                                                                   int id;
*/
                                                                  %>
                                        
					<th align="left" > 
                                                                                                                    <select  name="assigned_user_id">
                                                                                                                                    <%  while(resultset.next()){ 
                                                                                                                                                    //id =  resultset.getInt(1);  
                                                                                                                                                    ids =  resultset.getString(1);  
                                                                                                                                                    first_name = resultset.getString(2);
                                                                                                                                                    last_name = resultset.getString(3);
                                                                                                                                                    concat = first_name + " "+ last_name;
                                                                                                                                                   // resultset.getString(6)
                                                                                                                                                    %>
                                                                                                                                                        <option name="assigned_user_id" value="<%= ids %>"><%= concat %></option>
                                                                                                                                        <% } %>
                                                                                                                      </select> 
                                        </th>
                                                                                                        
<th> </th>
				</tr>
                                                                                                                                                        <%
                                                                                                                        //**Should I input the codes here?**
                                                                                                                         connection.close();  
                                                                                                                                }
                                                                                                                                catch(Exception e)
                                                                                                                                {
                                                                                                                                     out.println("wrong entry"+e);
                                                                                                                                }
                                                                                                                        %>

                                
                                <tr>
				<td>Issue status</td>
                                        
					<th align="left" > 
                                                                                                                    <select  name="issue_status">
                                                                                                                                    <option>Open</option>
                                                                                                                                    <option>For Fixing</option>
                                                                                                                                    <option>For Testing</option>
                                                                                                                                    <option>Closed</option>
                                                                                                                        
                                                                                                                      </select> 
                                        </th>
                                                                                                        
<th> </th>
				</tr>
				<tr>
					<td>Issue Description</td>
					<td><textarea  name="issue_description" maxlength="1024" style="min-width: 550px ; max-width:550px; min-height: 150px; max-height: 150px;"/></textarea></td></tr>
				<td>Platform</td>
					<td><input type="text" name="platform" maxlength="24" /></td>
				</tr>
				</tr>
				<td>Platform Version</td>
					<td><input type="text" name="platform_version" maxlength="24" /></td>
				</tr>
                                <td>Browser </td>
					<td><input type="text" name="browser" maxlength="24" /></td>
				</tr>
		 <td>Browser Version</td>
					<td><input type="text" name="browser_version" maxlength="24" /></td>
				</tr>
                                </tr>
		 <td>Attach File</td>
					<td><input type="file" id="myfile" name="attached_file"></td>
				</tr>
                                </tr>
		 <td></td>
					<td></td>
				</tr>
                              
                                <tr>
		 <td></td>
					<td><input type="submit" value="Add Issue" /></td>
				</tr>
                                 </tr>
		 <td></td>
					<td></td>
				</tr>
                        </table>
			</form>
			</div>
    </body>
</html>

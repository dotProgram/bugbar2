3<%-- 
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
String sqlWhereCondQuery_user =""; 
String sqlWhereCondQuery_user2 = null; 
String sqlWhereCondQuery_project =""; 
String sqlWhereCondQuery_project2 = null; 

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
                                                          
                                                                
                                                             /* ==================         The Following lines of code Will Get the *USERS* Added by the Admin    ===================
                                                                  ==================                             of the Logged user Or the Admin Logged In                            =================== 
                                                                  ============================================================================================== */
                                                            
                                                                    if(session.getAttribute("logged_user_name_role").equals("user")){
                                                            
                                                                         
                                                                         System.out.println("||||||||||||||||||||||||||||||||||||-INSIDE THE ASSIGN USER DROP-DOWN-||||||||||||||||||||||||||||||||||"+adminAddedUsers+"\n");
                                                                         System.out.println("||||||||||||||||||||||||||||||||||||-IF Logged -In == User & ID-||||||||||||||||||||||||||||||||||"+String.valueOf(LoggedUserId_fetching_from_session)+";\n");
                                                                         System.out.println("select * from user where id = "+String.valueOf(LoggedUserId_fetching_from_session));
                                                                         System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                                                                         
                                                                         //Start
                                                                          System.out.println("INSIDE THE IF CONDITION USER\n");
                                                                           System.out.println("|||||||||||||||||||||||||||||++++++++++++|||||||||||||||||||||||||||\n");
                                                                                        //Find the Admin of the USER and Accordingly dervice Projects Added by the Admin
                                                                                    
                                                                                            int sessionIduser= (int)LoggedUserId_fetching_from_session;
                                                                                            adminOfLoggedUser = cd.adminID("admin_user_relationship", "adminID","userID", String.valueOf(LoggedUserId_fetching_from_session)  );
                                                                                            System.out.println("Finding the Admin of the USER DROP-DOWN = "+String.valueOf(LoggedUserId_fetching_from_session)); 
                                                                                            System.out.println("Reterived the Admin = "+adminOfLoggedUser); 
                                                                                    //    System.out.println("\n >><< Reterived the Function Returns = "+retrieve(LoggedUserId_fetching_from_session, cd)); 
                                                                                            System.out.println("|||||||||||||||||||||||||||||++++++++++++|||||||||||||||||||||||||||\n");
                                                                                            
                                                                                            
                                                                         //End
                                                                                                        //**--Reteriving te USERS added by the ADMIN of the Logged USer--**
                                                                                                           try {
                                                                                                          adminAddedUsers = cd.userID_int("admin_user_relationship", "userID", "adminID", adminOfLoggedUser);
                                                                                                         //   adminAddedUsers = cd.userID_int("admin_user_relationship", "userID", "adminID", LoggedUserId_fetching_from_session);
                                                                                                         //   out.println("\n"+adminAddedUsers); 

                                                                                                            for(int i = 0; i < adminAddedUsers.size(); i++ )
                                                                                                            {
                                                                                                                       sqlWhereCondQuery_user = adminAddedUsers.get(i);

                                                                                                                      if(sqlWhereCondQuery_user2 == null){
                                                                                                                        sqlWhereCondQuery_user2 =  sqlWhereCondQuery_user;   
                                                                                                                        }
                                                                                                                       else{
                                                                                                                       sqlWhereCondQuery_user2 = sqlWhereCondQuery_user2+", "+sqlWhereCondQuery_user;
                                                                                                                        }
                                                                                                                    //    out.println("\n \n <br> adminAddedUsers are as >< = "+adminAddedUsers.get(i));  
                                                                                                                        System.out.println("\n }}}{{{ ADMIN AddedUsers }}}{{{: "+adminAddedUsers.get(i));
                                                                                                            }
                                                                                                                       //    out.println("\n \n <br><br><br><br> adminAddedUsers : sqlWhereCondQuery2are as >< = "+String.valueOf(sqlWhereCondQuery002));  
                                                                                                       } 
                                                                                                catch (ClassNotFoundException | SQLException ex) {
                                                                                                        //     Logger.getLogger(viewMembers.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                         }
                                                                         
                                                                         System.out.println("\n }}}{{{ ADMIN AddedUsers AL:: }}}{{{: "+sqlWhereCondQuery_user2);
                                                                       
                                                                               
                                                                    }
                                                                
                                                                   else { //========= If the logged user is ADMIN =========
                                                                        System.out.println("|||||||-//\\//\\//========= If the logged user is ADMIN =========-||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
                                                                      //     out.println("<br>Users added by admin no: "+LoggedUserId_fetching_from_session+"<br>"); 
                                                                                                try {
                                                                                                         // adminAddedUsers = cd.userID_int("admin_user_relationship", "userID", "adminID", 203);
                                                                                                          adminAddedUsers = cd.userID_int("admin_user_relationship", "userID", "adminID", LoggedUserId_fetching_from_session);
                                                                                                         //   out.println("\n"+adminAddedUsers); 

                                                                                                            for(int i = 0; i < adminAddedUsers.size(); i++ )
                                                                                                            {
                                                                                                                       sqlWhereCondQuery_user = adminAddedUsers.get(i);

                                                                                                                      if(sqlWhereCondQuery_user2 == null){
                                                                                                                        sqlWhereCondQuery_user2 =  sqlWhereCondQuery_user;   
                                                                                                                        }
                                                                                                                       else{
                                                                                                                       sqlWhereCondQuery_user2 = sqlWhereCondQuery_user2+", "+sqlWhereCondQuery_user;
                                                                                                                        }
                                                                                                                    //    out.println("\n \n <br> adminAddedUsers are as >< = "+adminAddedUsers.get(i));  
                                                                                                                        System.out.println("\n \n <br> adminAddedUsers are as >< = "+adminAddedUsers.get(i));
                                                                                                            }
                                                                                                                       //    out.println("\n \n <br><br><br><br> adminAddedUsers : sqlWhereCondQuery2are as >< = "+String.valueOf(sqlWhereCondQuery002));  
                                                                                                       } 
                                                                                                catch (ClassNotFoundException | SQLException ex) {
                                                                                                        //     Logger.getLogger(viewMembers.class.getName()).log(Level.SEVERE, null, ex);
                                                                                                         }
                                                                  System.out.println(" =================================================="); 
                                                                 System.out.println(" select * from user where id IN ('"+sqlWhereCondQuery_user2+"')");  
                                                                 System.out.println(" ==================================================");
                                                                           }
                                                                    
                                                                         resultset = statement.executeQuery("select * from user where id IN ("+sqlWhereCondQuery_user2+")");
                                                                         System.out.println("select * from user where id IN ("+sqlWhereCondQuery_user2+")");
                                                                         sqlWhereCondQuery_user2 = null;
                                                                    

                                                               //  out.println("<br> ===================select * from user where id IN ('"+sqlWhereCondQuery_user2+"')===================<br><br>");  
                                                                 // ==> resultset = statement.executeQuery("select * from user where id IN ("+sqlWhereCondQuery_user2+")") ;  
                                                                 
                                                             /* ==================         The Above lines of code Will Get the Users Added by the Admin          ===================
                                                                  ==================                             of the Logged user Or the Admin Logged In                          =================== 
                                                                  ============================================================================================== */
                                                                   
                                                                   
                                                                   
                                                                   
                                                                     //  String database_table, String getThisColumn, String whereParameter, String whereParametervalue) throws ClassNotFoundException, SQLException{
                                                                      // Will check if the Admin Is Logged or The User and fetch the Project List Accordingly.
                                                                      /* ==================         The Following lines of code Will Get the >* Project <* Added by the Admin/User    ===================
                                                                  ==================                             of the Logged user Or the Admin Logged In                          =================== 
                                                                  ============================================================================================== */
                                                                      
                                                                      if(session.getAttribute("logged_user_name_role").equals("user")){
                                                                                           System.out.println("Logged Client is  USER");  
                                                                                        //Find the Admin of the USER and Accordingly dervice Projects Added by the Admin
                                                                                        // LoggedUserId_fetching_from_session
                                                                                            int sessionIduser= (int)LoggedUserId_fetching_from_session;
                                                                                            adminOfLoggedUser = cd.adminID("admin_user_relationship", "adminID","userID", String.valueOf(LoggedUserId_fetching_from_session)  );

                                                                                             System.out.println("Finding the Admin of the USER For PROJECT Drop-Down = "+String.valueOf(LoggedUserId_fetching_from_session)); 
                                                                                             System.out.println("Reterived the Admin For PROJECT Drop-Down = "+adminOfLoggedUser); 
                                                                                    //   System.out.println("\n >><< Reterived the Function Returns = "+retrieve(LoggedUserId_fetching_from_session, cd)); 
                                                                                                  
                                                                                         
                                                                                                  IssueDetails_Array = cd.adminAddedProjectsDetails("project_admin_relationship", "project_uid", adminOfLoggedUser);
                                                                                                                   for(int i = 0; i < IssueDetails_Array.size(); i++ )
                                                                                                                   {
                                                                                                                            sqlWhereCondQuery_project = IssueDetails_Array.get(i);
                                                                                                                            
                                                                                                                           if(sqlWhereCondQuery_project2 == null){
                                                                                                                                          sqlWhereCondQuery_project2 =  sqlWhereCondQuery_project;   }
                                                                                                                            else{
                                                                                                                                         sqlWhereCondQuery_project2 = sqlWhereCondQuery_project2+"', '"+sqlWhereCondQuery_project;
                                                                                                                                     }  // out.println("\n \n <br> loop array value = "+IssueDetails_Array.get(i));  
                                                                                                                     }
                                                                                              
                                                                                                System.out.println("\nFor PROJECT Drop-Down The PROJECT Unique ID  = "+String.valueOf(sqlWhereCondQuery_project2)); 
                                                                                                                      
                                                                                       //    resultset2 =statement2.executeQuery("select * from users where userID IN ('"+sqlWhereCondQuery_project2+"')" ) ;
                                                                                       resultset2 =statement2.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery_project2+"')" );  
                                                                                           
                                                                                                                }//If User Ends
                                                                  
                                                                  
                                                                  
                                                                 // session.getAttribute("logged_user_name_role").equals("admin")
                                                                  
                                                                           else { //If the logged user is ADMIN
                                                                 System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~ <ADmin> = "+LoggedUserId_fetching_from_session ); 
                                                                                            System.out.println("\n Logged Client is  <ADmin> = "+LoggedUserId_fetching_from_session ); 
                                                                                            IssueDetails_Array = cd.adminAddedProjectsDetails("project_admin_relationship", "project_uid", LoggedUserId_fetching_from_session);
                                                                                         // IssueDetails_Array = cd.adminAddedProjectsDetails("project_admin_relationship", "project_uid", 203);
                                                                                           
                                                                                             for(int i = 0; i < IssueDetails_Array.size(); i++ ){
                                                                                                    sqlWhereCondQuery_project = IssueDetails_Array.get(i);
                                                                                                   if(sqlWhereCondQuery_project2 == null){
                                                                                                                  sqlWhereCondQuery_project2 =  sqlWhereCondQuery_project;   }
                                                                                                    else{
                                                                                                                 sqlWhereCondQuery_project2 = sqlWhereCondQuery_project2+"', '"+sqlWhereCondQuery_project;
                                                                                                             }  // out.println("\n \n <br> loop array value = "+IssueDetails_Array.get(i));  
                                                                                              }
                                                                                System.out.println("\n ^^^^ ````^^^^~~~This is  Impt for ADMIN***Executing Query = "+sqlWhereCondQuery_project2 );           
                                                                                resultset2 =statement2.executeQuery("select * from project where project_uid IN ('"+sqlWhereCondQuery_project2+"')" );  
                                                                   
                                                                  }
                                              /* ==================         The Above lines of code Will Get the *Project* Added by the Admin/User    ===================
                                                                  ==================                             of the Logged user Or the Admin Logged In                          =================== 
                                                                  ============================================================================================== */
                                                                 
                                                             sqlWhereCondQuery_project2 = null;
                                                                   
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
     
       
        <div align="center" style='margin-top: 1%; height:550px; background-color: #f8f9fa;'">

<form action="LogIssue" method="post" >
			<table style="with: 50%">
                                                                                                              <tr><td></td>
                                                                                                                   <td><% try{
                                                                                                                                if(request.getAttribute("invalid")!= null && request.getAttribute("invalid").toString().equals("inval")){
                                                                                                                                    out.println("<span style='color:red;'>");
                                                                                                                                    out.println("Empty issue_title or issue_description");
                                                                                                                                    out.println("</span>");
                                                                                                                                } else if(  request.getAttribute("auth") != null && request.getAttribute("auth").toString().equals("invalid")){
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
                                                                                                                                                       <option >Select Project</option>
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
                                                                                                           <th align="left" > 
                                                                                                                    <select  name="assigned_user_id">
                                                                                                                                    <option >Select User</option>
                                                                                                                                    <%  while(resultset.next()){ 
                                                                                                                                                    id =  resultset.getInt(1);  
                                                                                                                                                    //ids =  resultset.getString(1);  
                                                                                                                                                    first_name = resultset.getString(3);
                                                                                                                                                    last_name = resultset.getString(4);
                                                                                                                                                    concat = first_name + " "+ last_name;
                                                                                                                                                   // resultset.getString(6)
                                                                                                                                                   System.out.println("\n \n <br> adminAddedUsers List in Drop-down >< = "+concat);
                                                                                                                                                    %>
                                                                                                                                                        
                                                                                                                                                        <option name="assigned_user_id" value="<%= id %>"><%= concat %></option>
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

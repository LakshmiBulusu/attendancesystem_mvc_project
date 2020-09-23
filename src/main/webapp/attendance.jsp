<!DOCTYPE html>
<html lang="en">
<head>
  <title> SCHOOL ATTENDANCE </title>
  <link href="./css/style.css" rel="stylesheet">
  <script type="text/javascript" src="./js/school.js"></script>
</head>
<body>
 <%@page import="java.util.ArrayList"%>
 <%@page import="com.github.perscholas.model.StudentDetails"%>
 <%@page import="java.util.Iterator"%>
 <%@page import="java.lang.String"%>
<div class="header">
      <h1><b>DR.WRIGHTS ELEMENTARY SCHOOL</h1>
	 <h2><b>Future Leaders For Tomorrow </h2>
       <img class ="schoolimage1" src="img/actualschool.png" alt="schoolemoji"  height="30%" width="30%">
</div>
<div class="navbar">
      <a href="#">Student Attendance</a>
      <a href="ReadMe.html" class="right">Help</a>
</div>
<form action ="AttendanceSystemServlet" method="post">
<input type="hidden" id ="pagename" name="pagename" value="attendance">
<table cellspacing="1" cellpadding="0">
 <div class="flex-container">
 <tr>
	 <td><b>Student Photo</b></td>
	 <td><b>Student First Name<b></td>
	 <td><b>Student Last Name<b></td>
	 <td><b>Emergency Conact<b></td>
	 <td><b>Parent Email<b></td>
	 <td><b>Has Present<b></td>
 </tr>

 <% ArrayList<StudentDetails> studentList = (ArrayList) session.getAttribute("StudentList"); %>
 <%
  // Iterating through studentList
  System.out.println("I'm in jsp"+session.getAttribute("StudentList"));
  if(session.getAttribute("StudentList") != null)  // Null check for the object
  {
	Iterator<StudentDetails> iterator = studentList.iterator();  // Iterator interface

	while(iterator.hasNext())  
	{
		StudentDetails studentDetails = iterator.next(); 
  %>
	<tr>
		<td>
		      <div>
			     <img class ="myimage" src="img/studentemoji.png"/>
		      </div>
		</td>
		<td>
			 <div class ="divsize">
				<%=studentDetails.getFirstname()%> 
             </div>
		</td>
		<td>
			 <div class ="divsize">
				<%=studentDetails.getLastname()%> 
             </div>
		</td>
		<td>
			 <div class ="divsize">
				<%=studentDetails.getEmergencycontact()%> 
             </div>
		</td>
		<td>
			 <div class ="divsize">
				<%=studentDetails.getParentemailid()%> 
             </div>
		</td>
	
		<td>
		    <div>
			   <input type="checkbox"  name="checkedrows" value = "<%=studentDetails.getStudentid()%>"> </input>
             </div>
		</td>
	</tr>
	<br>
	<%
	}
	%>
 <%
 }
 %>
</div>
</table>
 <div align="center">
     <input type="submit" value="submit">
  </div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>DR.WRIGHTS ELEMENTARY SCHOOL</title>
    <link href="./css/style.css" rel="stylesheet">
    <script type="text/javascript" src="./js/school.js"></script>
</head> 
<body> 
<div class="header">
      <h1><b>DR.WRIGHTS ELEMENTARY SCHOOL</h1>
	 <h2><b>Future Leaders For Tomorrow </h2>
    <img class ="schoolimage1" src="img/actualschool.png" alt="schoolemoji"  height="30%" width="30%">
</div>
<div align="center">
    <h4><b>Enter your details to update in the school records and click Submit! </b></h4>
    <form action ="AttendanceSystemServlet" method="post">
	    Student ID<input type="text" id="studentid" name="studentid"><br><br> 
        Address<input type="text" id="address" name="address"><br><br>    
        Emergency Contact <input type="text" id="emergencycontact" name="emergencycontact"><br><br><br>
		parentemail ID<input type="text" id="parentemailid" name="parentemailid"><br><br><br>
        <button type="submit" ><b>Submit</b></button>
        <input type="hidden" id ="pagename" name="pagename" value="studentdetails">
    </form>
    </div>
</body>
</html>
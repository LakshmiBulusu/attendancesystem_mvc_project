<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%-- invoking servlet --%>
<!--<jsp:include page="AttendanceSystemServlet" flush="true" /> -->
<html lang="en">
<head>
    <title>Account Creation</title>
    <link href="./css/style.css" rel="stylesheet">
    <script type="text/javascript" src="./js/school.js"></script>
</head> 
<body> 

<div class="header">
      <h1><b>DR.WRIGHTS ELEMENTARY SCHOOL</h1>
	 <h2><b>Future Leaders For Tomorrow </h2>
	 <img class ="schoolimage1" src="img/actualschool.png" alt="schoolemoji"  height="30%" width="30%">
</div>
<div>
    <div align="center">
    <h2><b>Enter your Details </b></h2>
	<h3><b>Please enter your Unique Idenitifcation ID provided by School Administrator to create an account. If you don't have then please contact School Administrator.</b></h3>
	
    <form action ="AttendanceSystemServlet" method="post">
        Unique ID<input type="text" id="id" name="id"><br><br>
        User Name<input type="text" id="username" name="username"><br><br>
        Password <input type="text" id="password" name="password"><br>
	   <input type="submit" value="submit">
       <input type="hidden" id ="pagename" name="pagename" value="accountcreation">
    </form>
    </div>
</div>
</body>
</html>
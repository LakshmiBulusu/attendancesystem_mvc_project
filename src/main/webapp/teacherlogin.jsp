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
    <h4><b>Enter your User Name, Password and Click Submit! </b></h4>
    <form action ="AttendanceSystemServlet" method="post">
        <label for="name">UserName</label><input type="text" id="username" name="username"><br><br>
        <label for="name">Password</label><input type="text" id="password" name="password"><br><br>
        <button type="submit"><b>Submit</b></button>
        <input type="hidden" id ="pagename" name="pagename" value="teacherlogin">
    </form>
</div>
</body>
</html>
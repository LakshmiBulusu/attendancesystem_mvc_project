<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<%
    String message = null;
    if(request.getParameter("login") != null) {
        String userName = request.getParameter("username");
        String userPass = request.getParameter("password");
        if("tom".equals(userName) && "jerry".equals(userPass)) {
            response.sendRedirect("success.jsp");
        } else {
            message = "Password and Username does not match";
        }
    }
%>

<body>
    <%
        if(message != null) {
            out.print("<span style='color:red'>" + message + "</span>");
        }
    %>

    <form method="post">
        UserName<input id="input-username" type="text" name="username"/><br />
        Password<input id="input-password" type="text" name="password"><br />
        <input id="login-button" type="submit" name="login" value="Login" />
    </form>
</body>
</html>
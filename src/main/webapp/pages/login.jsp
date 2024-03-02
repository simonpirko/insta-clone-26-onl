<%--
  Created by IntelliJ IDEA.
  User: Sokol-1
  Date: 01.03.2024
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
</head>
<body>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
<p>${message}</p>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Sokol-1
  Date: 01.03.2024
  Time: 2:23
  To change this template use File | Settings | File Templates.

Страница изменений пароля и имени
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Credentials</title>
</head>
<body>
<h1>Change Username/Password</h1>

<form method="post" action="/change-credentials">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" required/><br/>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required/><br/>
    <label for="new-username">New username:</label>
    <input type="text" name="new-username" id="new-username" required/><br/>
    <label for="new-password">New password:</label>
    <input type="password" name="new-password" id="new-password" required/><br/>
    <input type="submit" value="Change"/>
</form>

<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<a href="/home">Back to Home Page</a>
</body>
</html>

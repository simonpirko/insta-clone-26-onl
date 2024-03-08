<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 08.03.2024
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>
</head>
<body>
<h1>${username.username}</h1>
<form method="post" action="userPage">
    <input type="hidden" name="username" value="${username.username}">
    <button>sub</button>
</form>
<form action="subscription" method="get">
    <input type="hidden" name="subscription" value="${username.username}">
    <button>subscription</button>
</form>
</body>
</html>

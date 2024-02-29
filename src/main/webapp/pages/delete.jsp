<%@ page import="by.tms.instaclonec26onl.storage.InMemoryUserStorage" %><%--
  Created by IntelliJ IDEA.
  User: Sokol-1
  Date: 01.03.2024
  Time: 2:14
  To change this template use File | Settings | File Templates.

Админская функция удаления юзеров
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>

<%
    String username = request.getParameter("username");
    InMemoryUserStorage storage = (InMemoryUserStorage) request.getSession().getAttribute("storage");
    storage.delete(user);
%>

<a href="/admin">Back to admin page</a>
</body>
</html>
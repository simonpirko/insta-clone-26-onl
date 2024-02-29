<%--
  Created by IntelliJ IDEA.
  User: Sokol-1
  Date: 01.03.2024
  Time: 1:23
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Admin Page</h1>

<table border="1">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <form method="post" action="/delete">
                    <input type="hidden" name="username" value="${user.username}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/logout">Logout</a>
</body>
</html>
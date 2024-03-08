<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 08.03.2024
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="userPage" method="get">
    <input type="text" name="username" placeholder="username">
    <button>enter</button>
    <br>
</form>
<c:forEach var="users" items="${allUser}">
    <c:if test="${users != user.username}">
    <form action="userPage" method="get">
        <input type="hidden" name="username" value="${users}">
        <button>${users}</button>
    </form>
</c:if>
</c:forEach>
</body>
</html>

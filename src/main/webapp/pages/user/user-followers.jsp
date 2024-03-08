<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 08.03.2024
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>followers</title>
</head>
<body>
<c:forEach var="follower" items="${followers}">
    <form method="get" action="userPage">
        <input type="hidden" name="username" value="${follower}">
        <button>${follower}</button>
    </form>
</c:forEach>

</body>
</html>

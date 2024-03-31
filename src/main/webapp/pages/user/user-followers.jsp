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
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<ul>
<c:forEach var="follower" items="${followers}">
    <li><a href="http://localhost:8080/userPage?username=${follower}"> ${follower} </a></li>
</c:forEach>
</ul>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 08.03.2024
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subscribers</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<ul>
<c:forEach var="subscription" items="${subscriptions}">
   <li></li> <a href="http://localhost:8080/userPage?username=${subscription}"> ${subscription} </a></li
</c:forEach>
</ul>
</body>
</html>

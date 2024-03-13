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
</head>
<body>
<c:forEach var="subscription" items="${subscriptions}">
    <form method="get" action="userPage">
        <input type="hidden" name="username" value="${subscription}">
        <button>${subscription}</button>
    </form>
</c:forEach>
</body>
</html>

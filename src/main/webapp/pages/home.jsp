<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.user != null}">
        <h1>Hello ${sessionScope.user.name}!</h1>
        <a href="/profile">Hello</a>
    </c:if>

    <c:if test="${sessionScope.user == null}">
        <h1>Hello Guest!</h1>
        <a href="/registration">Registration</a>
        <a href="/login">Login</a>
    </c:if>
</div>
</body>
</html>


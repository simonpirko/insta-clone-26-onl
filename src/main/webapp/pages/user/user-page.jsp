<%--
  Created by IntelliJ IDEA.
  User: Savva
  Date: 08.03.2024
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>UserPage</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>${username}</h1>

<form method="post" action="userPage">
    <input type="hidden" name="username" value="${username}">
    <button>sub</button>
</form>

<a href="http://localhost:8080/subscription?username=${username}"> subscription </a>
<br>
<a href="http://localhost:8080/follower?username=${username}"> follower </a>


<c:forEach var="userPost" items="${post}">
    <div class="text-center mt-3">
        <c:set var="imgByte" value="${Base64.getEncoder().encodeToString(userPost.imagePost)}" />
        <img src="data:image/jpeg;base64,${imgByte}"
             class="img-fluid" width="30%" height="40%" alt="">
        <h4 class="mt-3">${username} : ${userPost.textPost}</h4>
    </div>
</c:forEach>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body class="profile-body">
<div class="content">
    <div class="circle" id="imageContainer">
        <img src="data:image/jpeg;base64,${base64Image}">
    </div>
    <div class="info">
        <div class="b-links">
            <a href="http://localhost:8080/subscription?username=${user.username}"class="button" > subscriptions </a>
            <a href="http://localhost:8080/follower?username=${user.username}" class="button" > follower </a>
            <a href="/search" class="button" >search</a>
        </div>
        <div class="bottom-info">
            <h1>${user.name}</h1>
            <a href="/settings" class="button">settings</a>
        </div>
    </div>
</div>
</body>
</html>
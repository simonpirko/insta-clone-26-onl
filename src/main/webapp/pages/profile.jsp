<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1>${user.name}</h1>
<a href="http://localhost:8080/subscription?username=${user.username}"> subscriptions </a>
<br>
<a href="http://localhost:8080/follower?username=${user.username}"> follower </a>
<br>
<a href="/search">search</a>
</body>
</html>
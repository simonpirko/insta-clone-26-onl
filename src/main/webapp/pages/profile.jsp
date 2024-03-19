<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<h1>${user.name}</h1>
<a href="/subscription">Friends</a>
<a href="http://localhost:8080/subscription?username=${user.username}"> subscriptions </a>
<br>
<a href="/search">Search</a>
</body>
</html>
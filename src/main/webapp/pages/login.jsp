<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<div class="form-container">
<form action="/login" method="post">
    <h1>Login</h1>
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="password" placeholder="Password">
    <button type="submit">Submit</button>
</form>
</div>
<p>${message}</p>
</body>
</html>

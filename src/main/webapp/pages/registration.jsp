<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<div class="form-container">
    <form action="/registration" method="post">
        <h1>Registration</h1>
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="username" placeholder="Username">
        <input type="text" name="password" placeholder="Password">
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Credentials</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<h1>Settings</h1>

<form method="post" action="/settings" class="setting-form" >
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" required/><br/>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" required/><br/>
    <label for="new-username">New username:</label>
    <input type="text" name="new-username" id="new-username" required/><br/>
    <label for="new-password">New password:</label>
    <input type="password" name="new-password" id="new-password" required/><br/>
    <input type="submit" value="Change"/>
</form>

<c:if test="${not empty error}">
    <p>${error}</p>
</c:if>

<h2>Update Profile Picture</h2>
<form id="uploadForm" method="post" action="/uploadProfilePicture" enctype="multipart/form-data" class="setting-form">
    <input type="file" id="uploadInput" name="photo" accept="image/*">
    <input type="submit" value="Upload">
</form>

<a href="/profile">Back to profile</a>
</body>
</html>
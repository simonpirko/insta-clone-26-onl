<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div class="profile-page">
    <div class="profile-header">
        <img src="<%= user.getProfilePicture() %>" alt="Profile picture" class="profile-picture">
        <div class="profile-info">
            <h1><%= user.getName() %></h1>
            <p><%= user.getBio() %></p>
            <a href="<%= user.getWebsite() %>" target="_blank"><%= user.getWebsite() %></a>
        </div>
    </div>
</div>
</body>
</html>
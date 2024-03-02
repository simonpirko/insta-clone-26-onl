<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div class="profile-page">
    <div class="profile-header">
        <img src="${user.profilePictureUrl}" alt="Profile picture" class="profile-picture">
        <div class="profile-info">
            <h1>${user.name}</h1>
            <p>${user.bio}</p>
            <a href="${user.website}" target="_blank">${user.website}</a>
        </div>
    </div>
</div>
</body>
</html>
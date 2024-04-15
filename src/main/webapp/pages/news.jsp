<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<div class="container-fluid">
    <div class="row">
        <!-- Левый блок с ссылками -->
        <div class="col-md-3">
            <div class="mb-3">
                <div class="rounded bg-primary" style="background-color: #2E86C1 !important; padding: 10px; text-align: center; width: calc(100% - 7rem);"> <!-- Уменьшаем ширину блока на 2rem (2 см) по каждой стороне -->
                    <a href="/profile" class="text-white text-decoration-none" style="font-size: 14px;">Your Profile</a>
                </div>
            </div>
            <div class="mb-3">
                <div class="rounded bg-primary" style="background-color: #2E86C1 !important; padding: 10px; text-align: center; width: calc(100% - 7rem);"> <!-- Уменьшаем ширину блока на 2rem (2 см) по каждой стороне -->
                    <a href="/search" class="text-white text-decoration-none" style="font-size: 14px;">Search</a>
                </div>
            </div>
            <div class="mb-3">
                <div class="rounded bg-primary" style="background-color: #2E86C1 !important; padding: 10px; text-align: center; width: calc(100% - 7rem);"> <!-- Уменьшаем ширину блока на 2rem (2 см) по каждой стороне -->
                    <a href="#" class="text-white text-decoration-none" style="font-size: 14px;">Recommendation</a>
                </div>
            </div>
        </div>

        <!-- Центральная лента с фотографиями -->
        <div class="col-md-9 text-center">
            <h2>News Feed</h2>
            <c:forEach var="post" items="${newsFeedPosts}">
                <div class="post-container">
                    <h5 class="user-name">${post.user.username}</h5>
                    <c:if test="${not empty post.imagePost}">
                        <c:set var="imgByte" value="${Base64.getEncoder().encodeToString(post.imagePost)}" />
                        <img src="data:image/jpeg;base64,${imgByte}" alt="Post Image" class="post-image">
                    </c:if>
                    <p>${post.textPost}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>

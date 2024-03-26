<%@ page import="java.util.Base64" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
<body>
<h1>${user.name}</h1>
<a href="http://localhost:8080/subscription?username=${user.username}"> subscriptions </a>
<br>
<a href="http://localhost:8080/follower?username=${user.username}"> follower </a>
<br>
<a href="/search">search</a>

<div>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        Add post
    </button>

    <!-- Модальное окно -->
    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Add post</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form  method="post" action="addPost" enctype="multipart/form-data">
                        <input type="file" name="image" id="photoInput">
                        <label>
                            <input type="text" name="text">
                        </label>
                        <input type="submit" value="Загрузить">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <c:forEach var="userPost" items="${post}">
        <div class="text-center mt-3">
            <c:set var="imgByte" value="${Base64.getEncoder().encodeToString(userPost.imagePost)}" />
            <img src="data:image/jpeg;base64,${imgByte}"
                 class="img-fluid" width="30%" height="40%" alt="">
            <h4 class="mt-3">${username} : ${userPost.textPost}</h4>
            <form method="post" action="deletePost">
                <input type="submit" value="Delete">
                <input type="hidden" name="idPost" value="${userPost.idPost}">
            </form>
        </div>
    </c:forEach>


<%--
        List<UserPost> userList = (List<UserPost>) request.getAttribute("post");

        if(!(userList == null)){
            userList.reversed();
            for (UserPost entry: userList) {
                byte[] imgPost = entry.getImagePost();
                String postText = entry.getTextPost();
                String idPost = String.valueOf(entry.getIdPost());
    %>

    <%
            }
        }
    --%>

</div>
</body>
</html>
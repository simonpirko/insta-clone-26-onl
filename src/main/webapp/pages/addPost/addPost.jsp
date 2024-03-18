<%@ page import="by.tms.instaclonec26onl.model.User" %>
<%@ page import="by.tms.instaclonec26onl.model.UserPost" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Post</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<!-- Кнопка-триггер модального окна -->
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
                <form action="" method="post" enctype="multipart/form-data">
                    <input type="file" name="image" id="photoInput">
                    <input type="text" name="text">
                    <input type="submit" value="Загрузить">
                </form>
            </div>
        </div>
    </div>
</div>

<%
    List<UserPost> userList = (List<UserPost>) request.getAttribute("post");

    if(!(userList == null)){
        userList.reversed();
        for (UserPost entry: userList) {
                byte[] imageData = entry.getImagePost();
                String postText = entry.getTextPost();


%>
<div class="text-center mt-3">
    <img src="data:image/jpeg;base64,<%= new String(java.util.Base64.getEncoder().encode(imageData)) %>"
         class="img-fluid" width="30%" height="40%" alt="">
    <h4 class="mt-3"><%= postText %></h4>
</div>
<%
            }
        }
%>

</body>
</html>

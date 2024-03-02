
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Post</title>
</head>
<body>
<form action="/addPost" method="post" enctype="multipart/form-data">
    <input type="text" name="text">
    <input type="file" name="image" accept="image/*" id="photoInput">
    <input type="button" value="Загрузить" onclick="uploadPhoto()">
</form>
<div id="textContainer">
    Text ${post.post}
    <div id="imageContainer"></div>
</div>

<script>
  function uploadPhoto() {
    var file = document.getElementById("photoInput").files[0];
    var formData = new FormData();
    formData.append("photo", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "imageUploadTest", true);
    xhr.onload = function (e) {
      if (this.status == 200) {
        var imgSrc = "data:image/jpeg;base64," + this.responseText;
        document.getElementById("imageContainer").innerHTML = "<img src='" + imgSrc + "'>";
      }
    };
    xhr.send(formData);
  }
</script>
</body>
</html>

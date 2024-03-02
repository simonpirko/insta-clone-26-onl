<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Upload Form</title>
</head>
<body>
<form id="uploadForm" enctype="multipart/form-data">
    <input type="file" id="photoInput" accept="image/*">
    <input type="button" value="Загрузить" onclick="uploadPhoto()">
</form>
<div id="imageContainer"></div>

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



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/pages/style_modal.css">
</head>
<body>
<div id="imageModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <form id="uploadFormStories" method="post" action="/uploadStories" enctype="multipart/form-data" class="setting-form">
            <input type="file" id="uploadInput" name="stories" accept="image/*">
            <input type="submit" value="Upload">
        </form>
    </div>
</div>
</body>
</html>

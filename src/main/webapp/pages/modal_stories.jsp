<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/pages/style_modal.css">
    <script src="/pages/script.js"></script>
</head>
<body>
<div id="StoriesModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <img src="data:image/jpeg;base64,${base64Stories}">
    </div>
</div>
</body>
</html>
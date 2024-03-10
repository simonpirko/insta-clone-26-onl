<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
    // Получаем карту изображений из атрибутов запроса
    Map<byte[], String> imageMap = (Map<byte[], String>) request.getAttribute("post");

    for (Map.Entry<byte[], String> entry: imageMap.entrySet()) {
        byte[] imageData = entry.getKey();
        String postText = entry.getValue();

%>
<div class="text-center mt-3">
    <img src="data:image/jpeg;base64,<%= new String(java.util.Base64.getEncoder().encode(imageData)) %>"
         class="img-fluid" width="30%" height="40%" alt="">
    <h4 class="mt-3"><%= postText %></h4>
</div>
<%
    }
%>
</body>
</html>

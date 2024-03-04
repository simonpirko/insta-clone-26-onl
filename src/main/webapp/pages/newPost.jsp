<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // Получаем карту изображений из атрибутов запроса
    Map<byte[], List<String>> imageMap = (Map<byte[], List<String>>) request.getAttribute("post");

    for (Map.Entry<byte[], List<String>> entry: imageMap.entrySet()) {
        byte[] imageData = entry.getKey();
        List<String> postText = entry.getValue();

%>
<img src="data:image/jpeg;base64,<%= new String(java.util.Base64.getEncoder().encode(imageData)) %>" alt="">
<h4><%= postText %></h4>
<%
    }
%>
</body>
</html>

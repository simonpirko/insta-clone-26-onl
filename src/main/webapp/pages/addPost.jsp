<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Post</title>
</head>
<body>
<form action="addPost" method="post" enctype="multipart/form-data">
    <input type="text" name="text">
    <input type="file" name="image" accept="image/*" id="photoInput">
    <input type="submit" value="Загрузить" >
</form>


</body>
</html>

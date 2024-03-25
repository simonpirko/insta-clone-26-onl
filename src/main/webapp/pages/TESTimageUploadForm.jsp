<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image Upload Form</title>
    <link rel="stylesheet" type="text/css" href="/pages/style.css">
</head>
<body>
<form id="uploadForm" enctype="multipart/form-data"> <!-- Форма для загрузки изображения с использованием enctype="multipart/form-data" -->
    <input type="file" id="photoInput" accept="image/*"> <!-- Поле для выбора файла изображения -->
    <input type="button" value="Загрузить" onclick="uploadPhoto()"> <!-- Кнопка для вызова функции загрузки изображения -->
</form>
<div class="circle" id="imageContainer"></div> <!-- Блок для отображения загруженного изображения -->

<script>
    function uploadPhoto() { // Начало определения функции uploadPhoto
        var file = document.getElementById("photoInput").files[0]; // Получение выбранного файла изображения
        var formData = new FormData(); // Создание объекта FormData
        formData.append("photo", file); // Добавление выбранного файла в FormData под именем "photo"

        var xhr = new XMLHttpRequest(); // Создание объекта XMLHttpRequest
        xhr.open("POST", "imageUploadTest", true); // Настройка запроса, метод POST, адрес "imageUploadTest", асинхронный режим
        xhr.onload = function (e) { // Назначение обработчика события загрузки
            if (this.status == 200) { // Если статус ответа равен 200 (успешно)
                var imgSrc = "data:image/jpeg;base64," + this.responseText; // Создание строки с base64-представлением файла изображения
                document.getElementById("imageContainer").innerHTML = "<img src='" + imgSrc + "'>"; // Отображение изображения в блоке imageContainer
            }
        };
        xhr.send(formData); // Отправка объекта FormData на сервер
    }
</script>
</body>
</html>




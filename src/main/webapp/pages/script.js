function openImagePopup() {
    var newImageUrl = prompt("Введите URL новой картинки");
    if (newImageUrl) {
        var modal = document.getElementById('imageModal');
        var modalImg = document.getElementById('modalImage');
        modal.style.display = "block";
        modalImg.src = newImageUrl;
    }
}

function openImageUploader() {
    // Найдите форму по ее ID
    var form = document.getElementById("uploadForm");
    // Отобразите форму
    form.style.display = "block";
}


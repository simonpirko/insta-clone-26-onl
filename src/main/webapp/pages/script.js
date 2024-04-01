document.addEventListener("DOMContentLoaded", function() {
    var modalImage = document.getElementById("imageModal");
    var btnImage = document.getElementById("addImageButton");
    var spanImage = document.getElementsByClassName("close")[0];

    // Открыть модальное окно для изображения при клике на кнопку
    btnImage.onclick = function() {
        modalImage.style.display = "block";
    }

    // Закрыть модальное окно для изображения при клике на крестик
    spanImage.onclick = function() {
        modalImage.style.display = "none";
    }

    // Закрыть модальное окно для изображения при клике вне модального окна
    window.onclick = function(event) {
        if (event.target == modalImage) {
            modalImage.style.display = "none";
        }
    }

    var modalStories = document.getElementById("StoriesModal");
    var btnStories = document.getElementById("openModalBtn");
    var closeBtnStories = document.getElementsByClassName("close")[1];

    // Открыть модальное окно для историй при клике на кнопку
    btnStories.onclick = function() {
        modalStories.style.display = "block";
    }

    // Закрыть модальное окно для историй при клике на крестик
    closeBtnStories.onclick = function() {
        modalStories.style.display = "none";
    }

    // Закрыть модальное окно для историй при клике вне модального окна
    window.onclick = function(event) {
        if (event.target == modalStories) {
            modalStories.style.display = "none";
        }
    }
});
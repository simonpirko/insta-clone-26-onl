// Находим элементы модального окна и кнопку для закрытия
var modal = document.getElementById("myModal");
var closeButton = document.getElementsByClassName("close")[0];

// Функция для открытия модального окна
function openModal() {
    modal.style.display = "block";
}

// Функция для закрытия модального окна
function closeModal() {
    modal.style.display = "none";
}

// Закрываем модальное окно при клике на кнопку закрытия
closeButton.onclick = function() {
    closeModal();
}

// Закрываем модальное окно при клике вне его области
window.onclick = function(event) {
    if (event.target == modal) {
        closeModal();
    }
}
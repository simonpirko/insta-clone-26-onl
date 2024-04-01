document.addEventListener("DOMContentLoaded", function() {
    var addImageButton = document.getElementById("addImageButton");
    var modal = document.getElementById("myModal");
    var closeButton = modal.querySelector(".close");

    addImageButton.addEventListener("click", function(event) {
        event.preventDefault(); // Предотвращаем действие по умолчанию (переход по ссылке)
        modal.style.display = "block";
    });

    closeButton.addEventListener("click", function() {
        modal.style.display = "none";
    });

    window.addEventListener("click", function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
});
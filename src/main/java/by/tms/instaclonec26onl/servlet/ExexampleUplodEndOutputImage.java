package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.service.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/imageUploadTest")
@MultipartConfig
public class ExexampleUplodEndOutputImage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/TESTimageUploadForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем часть запроса, содержащую загруженное изображение
        Part filePart = request.getPart("photo");

        // Преобразуем содержимое части запроса (изображение) в байтовый массив (указываем своё хранилище)
        byte[] photoBytes = ImageUtil.convertToByteArray(filePart.getInputStream());

        // Преобразуем байтовый массив изображения в формат base64 (перед выводом)
        String base64Image = ImageUtil.convertToBase64(photoBytes);

        // Устанавливаем тип контента как plain text, поскольку будем отправлять строку base64
        response.setContentType("text/plain");

        // Отправляем строку base64 обратно клиенту
        response.getWriter().write(base64Image);
    }
}



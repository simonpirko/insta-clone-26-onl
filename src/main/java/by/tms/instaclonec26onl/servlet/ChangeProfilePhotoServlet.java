package by.tms.instaclonec26onl.servlet;

// TODO: написать логику смены аватарки (сделано)
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/change-profile-photo")
public class ChangeProfilePhotoServlet extends HttpServlet {

    private final InMemoryUserStorage storage = new InMemoryUserStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(req)) {
            throw new ServletException("Request is not multipart, cannot upload file");
        }

        ServletFileUpload upload = new ServletFileUpload();
        try {
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();

                    // Процесс загрузки фотки профиля (спасибо стаковефлоу и чатгпт:))))
                    if (sizeInBytes > 0) {
                        String filePath = "путь куда загружаем фотки" + UUID.randomUUID() + fileName;
                        File uploadedFile = new File(filePath);
                        item.write(uploadedFile);

                        // Обновление URL ссылки фотки профиля юзера с редиректом на страницу профиля (это я уже сам сделал)
                        String username = req.getParameter("username");
                        User user = storage.findUserByUsername(username);

                        user.setProfilePicture(filePath);
                        storage.save(user);
                    }
                }
            }
            resp.sendRedirect("/pages/profile");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/uploadProfilePicture")
@MultipartConfig
public class UploadProfilePictureServlet extends HttpServlet {
    UserService userService = new UserService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getCurrentUser(request);

        userService.updateAvatar(request, user);

        response.sendRedirect("/profile");
    }
}


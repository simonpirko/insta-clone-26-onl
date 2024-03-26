package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/uploadProfilePicture")
@MultipartConfig
public class UploadProfilePictureServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Part filePart = request.getPart("photo");

        user.addPicture(filePart);
        userService.update(user);

        response.sendRedirect("/profile");
    }
}


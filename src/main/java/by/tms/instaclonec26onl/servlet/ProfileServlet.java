package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

// Сервлет для страницы профиля
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userService.getCurrentUser(req);
        session.setAttribute("user", user);

        String base64Image = Base64.getEncoder().encodeToString(user.getProfilePicture());
        req.setAttribute("base64Image", base64Image);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }

}

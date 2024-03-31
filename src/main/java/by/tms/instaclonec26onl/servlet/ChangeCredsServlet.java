package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Изменение имени и пароля (смену аватарки - позже)
@WebServlet("/settings")
public class ChangeCredsServlet extends HttpServlet {

    private final UserService userService = new UserService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().
                getRequestDispatcher("/pages/settings.jsp").
                forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String newUsername = req.getParameter("new-username");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("new-password");

        User user = userService.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setUsername(newUsername);
            user.setPassword(newPassword);

            userService.update(user);
            resp.sendRedirect("/profile");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/pages/settings.jsp").forward(req, resp);
        }
    }
}

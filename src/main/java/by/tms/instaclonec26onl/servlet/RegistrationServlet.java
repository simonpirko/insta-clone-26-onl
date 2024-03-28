package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.SubscriptionService;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Сервлет регистрации новой учётки
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final SubscriptionService subscriptionService = new SubscriptionService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/pages/registration.jsp")
                .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String profilePictureUrl = ""; // Создана дефолтная пустая строка для URL

        if (name == null || username == null || password == null) {
            req.setAttribute("message", "All fields are required");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/registration.jsp");
            dispatcher.forward(req, resp);
            return;
        } else if (username.equals(userService.findUserByUsername(username).getUsername())) {
            req.setAttribute("message", "This user already exists");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        User user = new User(name, username, password, profilePictureUrl.getBytes(),new ArrayList<>(),new ArrayList<>());
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);

        try {
            userService.add(user);
            User newUser = userService.findUserByUsername(username);
            req.getSession().setAttribute("user", newUser);
            resp.sendRedirect("/profile");
        } catch (IllegalArgumentException e) {
            req.setAttribute("message", e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/home.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
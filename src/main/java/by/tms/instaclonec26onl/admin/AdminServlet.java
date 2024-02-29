package by.tms.instaclonec26onl.admin;

import by.tms.instaclonec26onl.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Сервлет админской учётки (доработать)
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user instanceof Admin) {
            // админ авторизован
            req.setAttribute("users", storage.getAllUsers());
            req.getRequestDispatcher("/admin.jsp").forward(req, resp);
        } else {
            // неавторизованный юзер или обычный юзер
            resp.sendRedirect("/login");
        }
    }
}

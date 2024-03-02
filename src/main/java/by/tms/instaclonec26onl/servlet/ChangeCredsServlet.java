package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Изменение имени и пароля (смену аватарки - позже)
@WebServlet("/change-creds-1")
public class ChangeCredsServlet extends HttpServlet {

    private InMemoryUserStorage storage;

    public ChangeCredsServlet(InMemoryUserStorage storage) {
        this.storage = storage;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String newUsername = req.getParameter("new-username");
        String password = req.getParameter("password");
        String newPassword = req.getParameter("new-password");
        String profilePicture = req.getParameter("profile-picture"); // Добавлена фотка профиля

        User user = storage.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            //user.setProfilePictureUrl(profilePicture);
            storage.save(user);
            resp.sendRedirect("/pages/profile");
        } else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("/pages/change-creds.jsp").forward(req, resp);
        }
    }
}

package by.tms.instaclonec26onl.servlet.userpage;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User myProfile = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        User byUsername;

        try {
            byUsername = userService.findByUsername(username);
            if (!myProfile.getUsername().equals(byUsername.getUsername())) {
                req.setAttribute("username", byUsername);
                getServletContext().getRequestDispatcher("/pages/user/user-page.jsp").forward(req, resp);
            }
            resp.sendRedirect("/profile");
        } catch (RuntimeException e) {
            resp.sendRedirect("/search");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User myProfile = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        User user = userService.findByUsername(username);
        if (myProfile.getSubscription().stream().noneMatch(u -> u.equals(user.getUsername()))) {
            myProfile.getSubscription().add(user.getUsername());
            user.getFollowers().add(myProfile.getUsername());
        } else {
            myProfile.getSubscription().remove(user.getUsername());
            user.getFollowers().remove(myProfile.getUsername());
        }
        resp.sendRedirect("/userPage?username=" + username);
    }
}

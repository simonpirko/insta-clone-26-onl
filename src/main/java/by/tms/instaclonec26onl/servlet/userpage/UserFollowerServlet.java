package by.tms.instaclonec26onl.servlet.userpage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.SubscriptionService;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/follower")
public class UserFollowerServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final SubscriptionService subscriptionService = new SubscriptionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        User user = userService.findUserByUsername(userName);
        List<User> userList = subscriptionService.findFollowerUser(user.getId());
        Collections.reverse(userList);
        req.setAttribute("followers", userList);
        getServletContext().getRequestDispatcher("/pages/user/user-followers.jsp").forward(req, resp);
    }
}


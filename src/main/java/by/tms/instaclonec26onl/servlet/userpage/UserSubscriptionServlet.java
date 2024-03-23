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

@WebServlet("/subscription")
public class UserSubscriptionServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final SubscriptionService subscriptionService = new SubscriptionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        User user = userService.findUserByUsername(username);
        List<User> userList = subscriptionService.findSubUser(user.getId());
        Collections.reverse(userList);
        req.setAttribute("subscriptions", userList);
        getServletContext().getRequestDispatcher("/pages/user/user-subscription.jsp").forward(req,resp);
    }

}

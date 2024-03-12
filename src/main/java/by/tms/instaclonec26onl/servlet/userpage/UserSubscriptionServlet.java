package by.tms.instaclonec26onl.servlet.userpage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/subscription")
public class UserSubscriptionServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        User subscription = userService.findByUsername(username);
        req.setAttribute("subscriptions", subscription.getSubscription()
                                                         .stream()
                                                         .map(User ::getUsername)
                                                         .toList());

        getServletContext().getRequestDispatcher("/pages/user/user-subscription.jsp").forward(req,resp);
    }

}

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

@WebServlet("/follower")
public class UserFollowerServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> followersName = new ArrayList<>();
        String userName = req.getParameter("followers");
        User user = userService.findByUsername(userName);
        for (User users : user.getFollowers()) {
            followersName.add(users.getUsername());
        }
        req.setAttribute("followers", followersName);
        getServletContext().getRequestDispatcher("/pages/user/user-followers.jsp").forward(req, resp);
    }
}


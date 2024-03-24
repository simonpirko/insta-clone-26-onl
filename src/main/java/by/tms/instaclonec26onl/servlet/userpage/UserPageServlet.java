package by.tms.instaclonec26onl.servlet.userpage;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.PostService;
import by.tms.instaclonec26onl.service.SubscriptionService;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.stream;

@WebServlet(value = "/userPage", name = "userPageServlet")
public class UserPageServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final SubscriptionService subscriptionService = new SubscriptionService();
    private final PostService postService = new PostService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User byUsername = userService.findUserByUsername(username);
        List<UserPost> userPostReverse = postService.findAllPost(byUsername);
        Collections.reverse(userPostReverse);
        req.setAttribute("post", userPostReverse);
        req.setAttribute("username", byUsername.getUsername());
        getServletContext().getRequestDispatcher("/pages/user/user-page.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User myProfile = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        User user = userService.findUserByUsername(username);
        List<User> userList = subscriptionService.findSubUser(myProfile.getId());

        for (User listUser : userList) {
            if (user.getId().equals(listUser.getId())) {
                subscriptionService.unSubUser(myProfile, user);
                resp.sendRedirect("/userPage?username=" + username);
                return;
            }
        }

        subscriptionService.addSubscribeUser(myProfile, user);
        resp.sendRedirect("/userPage?username=" + username);

        //subscriptionService.findSubUser(myProfile)
        //                .stream()
        //                .noneMatch(u -> u.getId().equals(user.getId()))

        /*if (userList.stream()
                .noneMatch(u -> u.getId().equals(user.getId()))) {
            subscriptionService.addSubscribeUser(myProfile, user);
        } else {
            subscriptionService.unSubUser(myProfile, user);
        }*/

    }
}

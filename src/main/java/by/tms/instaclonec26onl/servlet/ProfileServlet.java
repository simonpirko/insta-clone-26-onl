package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.PostService;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.Collections;
import java.util.List;
import java.util.Base64;

// Сервлет для страницы профиля
@WebServlet("/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final PostService postService = new PostService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getCurrentUser(req);
        List<UserPost> userPostReverse = postService.findAllPost(user);
        Collections.reverse(userPostReverse);
        req.setAttribute("post", userPostReverse);
        if (user.getProfilePicture() != null) {
            String base64Avatar = Base64.getEncoder().encodeToString(user.getProfilePicture());
            req.setAttribute("base64Avatar", base64Avatar);
        }
        if (user.getStories() != null){
            String base64Stories = Base64.getEncoder().encodeToString(user.getStories());
            req.setAttribute("base64Stories", base64Stories);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }

}

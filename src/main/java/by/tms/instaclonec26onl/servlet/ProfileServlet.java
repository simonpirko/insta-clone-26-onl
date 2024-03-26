package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.PostService;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.io.InputStream;
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
        req.setAttribute("username", user.getUsername());

        //String base64Image = Base64.getEncoder().encodeToString(user.getProfilePicture());
        //req.setAttribute("base64Image", base64Image);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }

}

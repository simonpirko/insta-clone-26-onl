package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.Comment;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.model.UserVideoPost;
import by.tms.instaclonec26onl.service.CommentService;
import by.tms.instaclonec26onl.service.PostService;
import by.tms.instaclonec26onl.service.UserService;
import by.tms.instaclonec26onl.service.VideoService;
import lombok.SneakyThrows;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

// Сервлет для страницы профиля
@WebServlet("/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final PostService postService = new PostService();
    private final CommentService commentService=new CommentService();
    private final VideoService videoService = new VideoService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getCurrentUser(req);
        List<UserPost> userPostReverse = postService.findAllPost(user);
        Map<Long, List<Comment>> commentsForPosts = new HashMap<>();
        List<UserVideoPost> userVideoPostReverse = videoService.findAllVideoPost(user);

        for (UserPost post : userPostReverse) {
            List<Comment> comments = commentService.findAllComment(post);
            commentsForPosts.put(post.getIdPost(), comments);
        }
        Collections.reverse(userPostReverse);
        req.setAttribute("post", userPostReverse);
        req.setAttribute("allComment", commentsForPosts);



        Collections.reverse(userVideoPostReverse);

        req.setAttribute("videoPost", userVideoPostReverse);
        if (user.getProfilePicture() != null) {
            String base64Avatar = Base64.getEncoder().encodeToString(user.getProfilePicture());
            req.setAttribute("base64Avatar", base64Avatar);
        }
        if (user.getStories() == null) {
            userService.getStories(user);
        }
        else {
            String base64Stories = Base64.getEncoder().encodeToString(user.getStories());
            req.setAttribute("base64Stories", base64Stories);
        }
        userService.deleteStories();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }

}

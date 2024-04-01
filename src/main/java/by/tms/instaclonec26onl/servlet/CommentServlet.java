package by.tms.instaclonec26onl.servlet;
import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.Comment;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.CommentService;
import by.tms.instaclonec26onl.service.PostService;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

    private final CommentService commentService=new CommentService();
    private final UserService userService = new UserService();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getCurrentUser(req);

        String action = req.getParameter("action");

        if ("addComment".equals(action)) {
            Long postId = Long.valueOf(req.getParameter("postId"));
            String commentText = req.getParameter("comment");
            commentService.addComment(commentText, postId, user);
        } else if ("deleteComment".equals(action)) {
            Long commentId = Long.valueOf(req.getParameter("commentId"));
            commentService.deleteComment(commentId);
        }
        resp.sendRedirect("/profile");
    }

}

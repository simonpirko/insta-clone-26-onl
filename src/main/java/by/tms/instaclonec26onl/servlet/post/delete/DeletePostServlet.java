package by.tms.instaclonec26onl.servlet.post.delete;

import by.tms.instaclonec26onl.service.CommentService;
import by.tms.instaclonec26onl.service.PostService;
import lombok.SneakyThrows;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {

    private final PostService postService = new PostService();
    private final CommentService commentService=new CommentService();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        long postId = Long.parseLong(req.getParameter("idPost"));
        commentService.deleteCommentsByPostId(postId);
        postService.deletePost(postId);

        resp.sendRedirect("/profile");
    }
}

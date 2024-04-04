package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.service.CommentService;
import by.tms.instaclonec26onl.service.VideoService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteVideoPost")
public class DeleteVideoPostServlet extends HttpServlet {
    private final VideoService videoService = new VideoService();
    //add comment
    private final CommentService commentService=new CommentService();
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long videoPostId = Long.parseLong(req.getParameter("id"));
        commentService.deleteCommentsByPostId(videoPostId);
        videoService.deleteVideoPost(videoPostId);

        resp.sendRedirect("/profile");
    }
}

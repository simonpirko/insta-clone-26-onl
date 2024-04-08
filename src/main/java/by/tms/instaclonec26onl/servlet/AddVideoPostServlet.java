package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;
import by.tms.instaclonec26onl.service.VideoService;
import lombok.SneakyThrows;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addVideoPost")
@MultipartConfig
public class AddVideoPostServlet extends HttpServlet {
    private final VideoService videoService = new VideoService();
    private final UserService userService = new UserService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getCurrentUser(request);
        videoService.addVideoPostDB(request, user);

        response.sendRedirect("/profile");
    }
}


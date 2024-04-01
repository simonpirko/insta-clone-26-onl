package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.ImageUtil;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadStories")
@MultipartConfig
public class UploadStoriesServlet extends HttpServlet {
    UserService userService = new UserService();

    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse res) {
        User user = userService.getCurrentUser(req);
        Part photo = req.getPart("stories");

        byte[] postImgByte = ImageUtil.convertToByteArray(photo.getInputStream());
        userService.addStories(postImgByte, user);

        res.sendRedirect("/profile");
    }

}

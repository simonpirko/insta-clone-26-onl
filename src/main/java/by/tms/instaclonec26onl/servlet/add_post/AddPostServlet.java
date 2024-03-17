package by.tms.instaclonec26onl.servlet.add_post;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.AddPostService;
import by.tms.instaclonec26onl.service.ImageUtil;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

// TODO  добавить множественное добавление постов (готово)

@WebServlet("/addPost")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    private final AddPostService addPostService = new AddPostService();
    private final UserService userService = new UserService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userService.getCurrentUser(req);
        session.setAttribute("user", user);
        req.getRequestDispatcher("/pages/addPost/addPost.jsp").forward(req,resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = userService.getCurrentUser(req);
        String textPost = req.getParameter("text");
        Part part = req.getPart("image");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());

        UserPost userPost = new UserPost(textPost, postImgByte, new User(user.getId()));

        addPostService.addPostDB(userPost);

        req.setAttribute("post", addPostService.findAllPost(user));
        req.getRequestDispatcher("/pages/addPost/addPost.jsp").forward(req,resp);

    }
}

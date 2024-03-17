package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.AddPostService;
import by.tms.instaclonec26onl.service.ImageUtil;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Сервлет для страницы профиля
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private final UserService userService = new UserService();
    private final AddPostService addPostService = new AddPostService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userService.getCurrentUser(req);
        session.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textPost = req.getParameter("text");
        Part part = req.getPart("image");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());

        UserPost userPost = new UserPost();
        userPost.setTextPost(textPost);
        userPost.setImagePost(postImgByte);
        userPost.getUser().setId(2L);

        addPostService.addPostDB(userPost);

        //req.setAttribute("post", addPostService.inMemoryPostStorage().getPost());
        req.setAttribute("post", addPostService.findAllPost());
        req.getRequestDispatcher("/pages/addPost/addPost.jsp").forward(req,resp);
    }
}

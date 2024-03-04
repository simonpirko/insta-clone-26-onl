package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.AddPostService;
import by.tms.instaclonec26onl.service.ImageUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

// TODO  добавить множественное добавление постов (готово)

@WebServlet("/addPost")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    AddPostService addPostService = new AddPostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/addPost.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String textPost = req.getParameter("text");
        Part part = req.getPart("image");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());

        UserPost userPost = new UserPost();
        userPost.setTextPost(textPost);
        userPost.setImagePost(postImgByte);
        addPostService.addPost(userPost);

        req.setAttribute("post", addPostService.inMemoryPostStorage().getPost());
        req.getRequestDispatcher("/pages/newPost.jsp").forward(req,resp);

    }
}

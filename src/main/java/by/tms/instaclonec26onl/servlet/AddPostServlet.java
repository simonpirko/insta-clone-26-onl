package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.service.AddPostService;
import by.tms.instaclonec26onl.service.ImageUtil;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

// TODO  добавить множественное добавление постов

@WebServlet("/addPost")
@MultipartConfig
public class AddPostServlet extends HttpServlet {

    AddPostService addPostService = new AddPostService();
    InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/addPost.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String textPost = req.getParameter("text");
        Part part = req.getPart("image");
        byte[] photoBytes = ImageUtil.convertToByteArray(part.getInputStream());
        String base64Image = ImageUtil.convertToBase64(photoBytes);

        UserPost userPost = new UserPost();
        userPost.setTextPost(textPost);
        userPost.setImagePost(base64Image);
        addPostService.addPost(userPost);

        resp.setContentType("text/plain");
        resp.getWriter().write(inMemoryPostStorage.getPost().size());
        req.setAttribute("post", inMemoryPostStorage);
        req.getRequestDispatcher("/pages/addPost.jsp").forward(req,resp);

    }
}

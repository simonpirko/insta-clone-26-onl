package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.sql.SQLException;
import java.util.List;

public class PostService {

    private final InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    @SneakyThrows
    public UserPost addPostDB (HttpServletRequest req, User user) {
        String textPost = req.getParameter("text");
        Part part = req.getPart("image");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());

        UserPost userPost = new UserPost(textPost, postImgByte, new User(user.getId()));

        inMemoryPostStorage.save_DB(userPost);
        return userPost;
    }

    public List<UserPost> findAllPost (User user) {
        return inMemoryPostStorage.findAllPostUser(user);
    }

    public List<UserPost> findAllByAccountId (long id) {
        return inMemoryPostStorage.findAllByAccountId(id);
    }

    public void deletePost(long userId){
        inMemoryPostStorage.delete(userId);
    }

}

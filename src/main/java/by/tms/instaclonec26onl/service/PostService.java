package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.PostDAO;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

public class PostService {

    private final PostDAO daoPost = new PostDAO();

    @SneakyThrows
    public UserPost addPostDB (HttpServletRequest req, User user) {
        String textPost = req.getParameter("text");
        Part part = req.getPart("image");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());

        UserPost userPost = new UserPost(textPost, postImgByte, new User(user.getId()));

        daoPost.save(userPost);
        return userPost;
    }

    public List<UserPost> findAllPost (User user) {
        return daoPost.findAllPostUser(user);
    }

    public List<UserPost> findAllByAccountId (long id) {
        return daoPost.findAllByAccountId(id);
    }

    public void deletePost(long userId){
        daoPost.delete(userId);
    }

}

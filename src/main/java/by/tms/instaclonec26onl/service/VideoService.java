package by.tms.instaclonec26onl.service;


import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserVideoPost;
import by.tms.instaclonec26onl.storage.VideoPostDAO;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.util.List;

public class VideoService {
    private final VideoPostDAO daoVideoPost = new VideoPostDAO();
    @SneakyThrows
    public UserVideoPost addVideoPostDB(HttpServletRequest request, User user){
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Part part = request.getPart("video");
        byte[] postVideoByte = VideoUtil.convertToByteArray(part.getInputStream());
        UserVideoPost userVideoPost = new UserVideoPost(title, description, postVideoByte,  new User(user.getId()));
        daoVideoPost.save(userVideoPost);
        return userVideoPost;
    }



    public void deleteVideoPost(long userId){
        daoVideoPost.delete(userId);
    }

    public List<UserVideoPost> findAllVideoPost(User user){
        return daoVideoPost.findAllVideoPostUser(user);
    }
}
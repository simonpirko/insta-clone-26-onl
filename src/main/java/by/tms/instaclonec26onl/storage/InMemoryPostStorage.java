package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import lombok.Data;

import javax.servlet.http.Part;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Data
public class InMemoryPostStorage {

    private final Map<String, String> post = new HashMap<>();

    public void save (UserPost userPost){
        post.put(userPost.getTextPost(), userPost.getImagePost());
    }

    public void delete (UserPost userPost) {
        post.remove(userPost.getTextPost(), userPost.getImagePost());
    }

}

package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import lombok.Data;
import java.util.*;
import java.util.List;

@Data
public class InMemoryPostStorage {

    private final Map<byte[], String> post = new HashMap<>();

    public void save (User userPost){
        post.put(userPost.getImagePost(), userPost.getTextPost());
    }

    public void delete (User userPost) {
        post.remove(userPost.getImagePost(), userPost.getTextPost());
    }

}

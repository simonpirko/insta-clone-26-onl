package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.UserPost;
import lombok.Data;
import java.util.*;
import java.util.List;

@Data
public class InMemoryPostStorage {

    private final Map<byte[], List<String>> post = new HashMap<>();

    public void save (UserPost userPost){
        post.put(userPost.getImagePost(), Collections.singletonList(userPost.getTextPost()));
    }

    public void delete (UserPost userPost) {
        post.remove(userPost.getImagePost(), Collections.singletonList(userPost.getTextPost()));
    }

}

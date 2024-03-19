package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;

import java.sql.SQLException;
import java.util.List;

public class PostService {

    private final InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    public void addPostDB (UserPost userPost) {
        inMemoryPostStorage.save_DB(userPost);
    }

    public List<UserPost> findAllPost (User user) throws SQLException {
        return inMemoryPostStorage().findAllPostUser(user);
    }
    public InMemoryPostStorage inMemoryPostStorage () {
        return inMemoryPostStorage;
    }

    public void removePost (UserPost userPost, int idPost){
        inMemoryPostStorage.delete(userPost, idPost);
    }

}

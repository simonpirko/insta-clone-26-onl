package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;

import java.sql.SQLException;

public class AddPostService {

    InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    public void addPost (UserPost userPost){
        inMemoryPostStorage.save(userPost);
    }
    public void addPostDB (UserPost userPost) {
        inMemoryPostStorage.save_DB(userPost);
    }

    public InMemoryPostStorage inMemoryPostStorage () {
        return inMemoryPostStorage;
    }

    public void removePost (UserPost userPost){
        inMemoryPostStorage.delete(userPost);
    }

}

package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;

public class AddPostService {

    InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    public void addPost (UserPost userPost){
        inMemoryPostStorage.save(userPost);
    }

    public void removePost (UserPost userPost){
        inMemoryPostStorage.delete(userPost);
    }

}

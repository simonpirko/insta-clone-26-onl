package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryPostStorage;

public class AddPostService {

    InMemoryPostStorage inMemoryPostStorage = new InMemoryPostStorage();

    public void addPost (User userPost){
        inMemoryPostStorage.save(userPost);
    }

    public InMemoryPostStorage inMemoryPostStorage () {
        return inMemoryPostStorage;
    }

    public void removePost (User userPost){
        inMemoryPostStorage.delete(userPost);
    }

}

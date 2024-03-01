package by.tms.instaclonec26onl.admin;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

// Создание админской учётки
public class Admin extends User {
    private InMemoryUserStorage storage;

    public Admin(String username, String password, InMemoryUserStorage storage) {
        super(username, password);
        this.storage = storage;
    }
}

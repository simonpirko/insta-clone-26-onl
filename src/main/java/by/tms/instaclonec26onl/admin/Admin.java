package by.tms.instaclonec26onl.admin;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

// Создание админской учётки с функцией удаления пользователей (функции модерации можно добавить)
public class Admin extends User {

    private InMemoryUserStorage storage;

    public Admin(String username, String password, InMemoryUserStorage storage) {
        super(username, password);
        this.storage = storage;
    }

    public void deleteUser(String username) {
        User user = storage.findByUsername(username);
        if (user != null) {
            storage.delete(user);
        }
    }
}

package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Типа БД
public class InMemoryUserStorage {
    private final static Map<String, User> users = new ConcurrentHashMap<>();
    // сохранение в Map
    public static void save(User user) {
        users.computeIfAbsent(user.getUsername(), k -> user);
    }

    public static User findByUsername(String username) {
        User user = users.get(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }

    public void delete(User user) {
    }
}

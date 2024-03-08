package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Типа БД
public class InMemoryUserStorage {
    private final static Map<String, User> users = new ConcurrentHashMap<>();
    private final static List<String> listUsername = new ArrayList<>();

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

    public List<String> findAllUsername() {
        List<User> list = users.values().stream().toList();
        for (User user : list) {
            listUsername.add(user.getUsername());
        }
        return listUsername;
    }
}

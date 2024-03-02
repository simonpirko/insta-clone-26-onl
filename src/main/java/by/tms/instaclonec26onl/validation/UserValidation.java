package by.tms.instaclonec26onl.validation;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

public class UserValidation {
    private final InMemoryUserStorage userStorage;

    public UserValidation(InMemoryUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public boolean validateUser(String username, String password) {
        // Проверка на null и пустой ввод
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // Поиск юзера по никнейму
        User user = findUserByUsername(username);
        if (user == null) {
            return false;
        }

        // Проверка пароля по equals
        return user.getPassword().equals(password);
    }

    private User findUserByUsername(String username) {
        return userStorage.findByUsername(username);
    }
}
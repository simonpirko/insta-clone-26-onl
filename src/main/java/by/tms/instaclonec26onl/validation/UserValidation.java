package by.tms.instaclonec26onl.validation;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.UserDAO;

// Валидация юзера
public class UserValidation {
    private final UserDAO storage;

    public UserValidation(UserDAO inMemoryUserStorage) {
        this.storage = inMemoryUserStorage;
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
        return storage.findUserByUsername(username);
    }
}

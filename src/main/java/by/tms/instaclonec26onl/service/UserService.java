package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {
    private final InMemoryUserStorage storage = new InMemoryUserStorage();

    // Сохранение в сторэдж
    public void add(User user) {
        storage.save(user);
    }

    // Поиск юзера в сторэдже по никнейму
    public User findByUsername(String username)  {
        return InMemoryUserStorage.findByUsername(username);
    }

    // Проверка сессии
    public User getCurrentUser(HttpServletRequest request) throws UserNotFoundException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new UserNotFoundException("User not found in session");
        }
        return user;
    }
}

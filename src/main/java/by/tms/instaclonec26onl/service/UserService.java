package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {

    InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    // Сохранение в сторэдж
    public void add(User user) {
        inMemoryUserStorage.save(user);
    }

    public void changeCreds (User user){
        inMemoryUserStorage.changeCredsUser(user);
    }

    // Поиск юзера в сторэдже по никнейму
    public User findUserByUsername(String username)  {
        return inMemoryUserStorage.findUserByUsername(username);
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
    public List<User> findAllUser() {
        return inMemoryUserStorage.findAllUser();
    }
}

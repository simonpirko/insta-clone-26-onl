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
        InMemoryUserStorage.save(user);
    }
    public void update(User user){
        InMemoryUserStorage.update(user);
        inMemoryUserStorage.save(user);
    }

    public void changeCreds (User user){
        inMemoryUserStorage.changeCredsUser(user);
    }

    // Поиск юзера в сторэдже по никнейму
    public User findUserByUsername(String username)  {
        return inMemoryUserStorage.findUserByUsername(username);
    }

    public User findUserById(long id) {
        return inMemoryUserStorage.findUserById(id);
    }

    // Проверка сессии
    public User getCurrentUser(HttpServletRequest request) throws UserNotFoundException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        return user;
    }
    public List<User> findAllUser() {
        return inMemoryUserStorage.findAllUser();
    }
}

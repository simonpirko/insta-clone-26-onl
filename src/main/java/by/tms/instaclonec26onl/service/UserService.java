package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.StoriesDAO;
import by.tms.instaclonec26onl.storage.UserDAO;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {

    private final UserDAO daoUser = new UserDAO();
    private final StoriesDAO daoStories = new StoriesDAO();

    // Сохранение в сторэдж
    public void add(User user) {
        daoUser.save(user);
    }

    @SneakyThrows
    public void updateAvatar(byte[] bytes, User user) {

        user.setProfilePicture(bytes);
        daoUser.updateAvatar(user);
    }
    public void update(User user){
        daoUser.update(user);
    }

    // Поиск юзера в сторэдже по никнейму
    public User findUserByUsername(String username)  {
        return daoUser.findUserByUsername(username);
    }

    public User findUserById(long id) {
        return daoUser.findUserById(id);
    }

    // Проверка сессии
    public User getCurrentUser(HttpServletRequest request) throws UserNotFoundException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        return user;
    }
    public List<User> findAllUser() {
        return daoUser.findAllUser();
    }

    public void addStories(byte[] postImgByte, User user) {
        user.setStories(postImgByte);
        daoStories.addStories(user);
    }
    public void getStories(User user){
        daoStories.getStories(user);
    }
    public void deleteStories(){
        daoStories.deleteStories();
    }
}

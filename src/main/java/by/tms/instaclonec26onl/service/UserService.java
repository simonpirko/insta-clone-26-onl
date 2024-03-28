package by.tms.instaclonec26onl.service;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.storage.InMemoryUserStorage;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.List;

public class UserService {

    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    // Сохранение в сторэдж
    public void add(User user) {
        inMemoryUserStorage.save(user);
    }

    @SneakyThrows
    public void updateAvatar(HttpServletRequest req, User user) {

        Part part = req.getPart("photo");

        byte[] postImgByte = ImageUtil.convertToByteArray(part.getInputStream());
        user.setProfilePicture(postImgByte);

        inMemoryUserStorage.updateAvatar(user);
    }
    public void update(User user){
        inMemoryUserStorage.update(user);
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

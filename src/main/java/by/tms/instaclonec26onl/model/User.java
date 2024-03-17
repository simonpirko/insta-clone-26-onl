package by.tms.instaclonec26onl.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class User {
    private static final String EMPTY_FIELD_MESSAGE = "Реклама пива запрещена, поэтому её здесь нет";

    private Long id;
    private String name;
    private String username;
    private String password;
    private String profilePicture;
    private List<User> subscription;
    private List<User> followers;
    private UserPost userPost;

    public User(UserPost userPost) {
        this.userPost = userPost;
    }

    public User(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    // Если любое поле null или пустая строка то бросаем IllegalArgumentException (добавил константу сообщения для проверки, кастомное исключение можно удалить)

    public User(String name, String username, String password, String profilePicture, List<User> subscription, List<User> followers) {
        this.validateField(name, "name", EMPTY_FIELD_MESSAGE);
        this.validateField(username, "username", EMPTY_FIELD_MESSAGE);
        this.validateField(password, "password", EMPTY_FIELD_MESSAGE);

        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.subscription = subscription;
        this.followers = followers;
    }

    private void validateField(String field, String fieldName, String errorMessage) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
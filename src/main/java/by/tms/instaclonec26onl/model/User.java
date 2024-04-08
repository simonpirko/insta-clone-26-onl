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
    private byte[] profilePicture;
    private List<String> subscription;
    private List<String> followers;
    private List<UserPost> userPostList;
    private byte[] stories;
    private List<UserVideoPost> userVideoPostList;

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String username, String password, byte[] profilePicture) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    public User(Long id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public User() {
    }

    // Если любое поле null или пустая строка то бросаем IllegalArgumentException (добавил константу сообщения для проверки, кастомное исключение можно удалить)

    public User(String name, String username, String password, byte[] profilePicture, List<String> subscription, List<String> followers) {
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
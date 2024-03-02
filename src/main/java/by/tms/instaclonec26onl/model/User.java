package by.tms.instaclonec26onl.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private static final String EMPTY_FIELD_MESSAGE = "Реклама пива запрещена, поэтому её здесь нет";

    private String name;
    private String username;
    private String password;
    private String profilePicture;

    // Если любое поле null или пустая строка то бросаем IllegalArgumentException (добавил константу сообщения для проверки, кастомное исключение можно удалить)
    public User(String name, String username, String password, String profilePicture) {
        this.validateField(name, "name", EMPTY_FIELD_MESSAGE);
        this.validateField(username, "username", EMPTY_FIELD_MESSAGE);
        this.validateField(password, "password", EMPTY_FIELD_MESSAGE);

        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
    }

    private void validateField(String field, String fieldName, String errorMessage) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
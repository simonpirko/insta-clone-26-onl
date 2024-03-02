package by.tms.instaclonec26onl.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class UserBio extends User{

    private List<String> bio;

    public UserBio(String name, String username, String password, List<String> bio) {
        super(name, username, password);
        this.bio = bio;
    }
    //Поле bio инициализируем пустым списком в пустом конструкторе. Но всё равно ошибка, хз почему. Вот такие пироги...
    public UserBio(String name, String username, String password) {
        super(name, username, password);
        this.bio = new ArrayList<>();
    }
}

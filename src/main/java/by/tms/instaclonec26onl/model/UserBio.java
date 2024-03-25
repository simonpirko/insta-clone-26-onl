package by.tms.instaclonec26onl.model;

import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@ToString
public class UserBio extends User{

    private List<String> bio;

//    public UserBio(String name, String username, String password, List<String> bio, String profilePictureUrl) {
//        super(name, username, password, profilePictureUrl);
//        this.bio = bio;
//    }
    //Поле bio инициализируем пустым списком в пустом конструкторе. Вот такие пироги...

    public UserBio(String name, String username, String password, byte[] profilePicture, List<String> subscription, List<String> followers, List<String> bio) {
        super(name, username, password, profilePicture, subscription, followers);
        this.bio = new ArrayList<>();
    }
}

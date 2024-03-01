package by.tms.instaclonec26onl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@ToString
public class UserBio extends User {
    private List<String> bio;

    public UserBio(String name, String username, String password, List<String> bio) {
        super(name, username, password);
        this.bio = bio;
    }
}

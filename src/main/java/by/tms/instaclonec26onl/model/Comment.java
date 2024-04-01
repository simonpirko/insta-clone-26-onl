package by.tms.instaclonec26onl.model;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class Comment {

    private Long id;
    private String comment;
    private UserPost userPost;
    private User user;

    public Comment(UserPost userPost, String comment, User user) {
        this.userPost = userPost;
        this.comment = comment;
        this.user=user;
    }

    public Comment(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public Comment(Long id, String comment, UserPost userPost, User user) {
        this.id = id;
        this.comment = comment;
        this.userPost = userPost;
        this.user = user;
    }

    @Override
    public String toString() {
        return  comment ;
    }
}

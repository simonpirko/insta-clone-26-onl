package by.tms.instaclonec26onl.model;

import lombok.Data;

@Data
public class UserPost {

    private long idPost;
    private String textPost;
    private byte[] imagePost;

    public UserPost(long idPost, String textPost, byte[] imagePost) {
        this.idPost = idPost;
        this.textPost = textPost;
        this.imagePost = imagePost;
    }

    public UserPost() {
    }
}

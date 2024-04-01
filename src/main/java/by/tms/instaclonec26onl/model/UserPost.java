package by.tms.instaclonec26onl.model;

import lombok.Data;

@Data
public class UserPost {

    private long idPost;
    private String textPost;
    private byte[] imagePost;
    private User user;

    public UserPost(long idPost, String textPost, byte[] imagePost, User user) {
        this.idPost = idPost;
        this.textPost = textPost;
        this.imagePost = imagePost;
        this.user = user;
    }

    public UserPost(String textPost, byte[] imagePost, User user) {
        this.textPost = textPost;
        this.imagePost = imagePost;
        this.user = user;
    }

    public UserPost(long idPost, String textPost, byte[] imagePost) {
        this.idPost = idPost;
        this.textPost = textPost;
        this.imagePost = imagePost;
    }

    public UserPost() {
    }

    public UserPost(long idPost) {
        this.idPost = idPost;
    }
}

package by.tms.instaclonec26onl.model;

import lombok.Data;

@Data
public class UserVideoPost {


    private long id;
    private String title;
    private String description;
    private byte[] video;
    private User user;

    public UserVideoPost(long id, String title, String description, byte[] video, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.video = video;
        this.user = user;
    }

    public UserVideoPost(String title, String description, byte[] video) {
        this.title = title;
        this.description = description;
        this.video = video;
    }

    public UserVideoPost(String title, String description, byte[] video, User user) {
        this.title = title;
        this.description = description;
        this.video = video;
        this.user = user;
    }

    public UserVideoPost(long id, String title, String description, byte[] video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.video = video;
    }

    public UserVideoPost() {
    }

    public UserVideoPost(long id) {
        this.id = id;
    }
}

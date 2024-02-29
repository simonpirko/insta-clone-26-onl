package by.tms.instaclonec26onl.model;

import java.util.List;

// TODO:
public class User {
    private String name;
    private String username;
    private String password;
    private List<String> bio;

    public User(String username, String password) {}

    public User(String name, String username, String password, List<String> bio) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getBio() {
        return bio;
    }

    public void setBio(List<String> bio) {
        this.bio = bio;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
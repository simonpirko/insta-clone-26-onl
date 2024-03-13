package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

@Data
public class InMemoryPostStorage {

    private final Map<byte[], String> post = new HashMap<>();

    public void save (UserPost userPost){
        post.put(userPost.getImagePost(), userPost.getTextPost());
    }

    public void save_DB (UserPost userPost)  {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_post values (?, ?, default)");
            preparedStatement.setBytes(1, userPost.getImagePost());
            preparedStatement.setString(2, userPost.getTextPost());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete (UserPost userPost) {
        post.remove(userPost.getImagePost(), userPost.getTextPost());
    }

}

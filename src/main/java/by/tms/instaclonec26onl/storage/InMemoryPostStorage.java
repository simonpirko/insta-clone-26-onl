package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import lombok.Data;

import java.sql.*;
import java.util.*;
import java.util.List;

@Data
public class InMemoryPostStorage {

    //private final Map<byte[], String> post = new HashMap<>();

    /*public void save (UserPost userPost){
        post.put(userPost.getImagePost(), userPost.getTextPost());
    }*/

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

    public List<User> findAllPostUser() throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_post");

        List<User> posts = new ArrayList<>();

        while (resultSet.next()) {
            byte[] byteImage = resultSet.getBytes(1);
            String textPost = resultSet.getString(2);
            long idPost = resultSet.getLong(3);
            posts.add(new User(new UserPost(idPost, textPost, byteImage)));
        }

        resultSet.close();

        return posts;
    }

    public void delete (UserPost userPost, int idPost) {
        /*try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from user_post where id='?'");
            preparedStatement.setBytes(1, userPost.getImagePost());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

}

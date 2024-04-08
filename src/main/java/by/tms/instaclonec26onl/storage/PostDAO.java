package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import lombok.Data;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.*;
import java.util.List;

@Data
public class PostDAO {

    //private final Map<byte[], String> post = new HashMap<>();

    /*public void save (UserPost userPost){
        post.put(userPost.getImagePost(), userPost.getTextPost());
    }*/

    public void save(UserPost userPost)  {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_post values (default, ?, ?, ?)");
            preparedStatement.setBytes(1, userPost.getImagePost());
            preparedStatement.setString(2, userPost.getTextPost());
            preparedStatement.setLong(3, userPost.getUser().getId());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    public List<UserPost> findAllPostUser(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_post");

        List<UserPost> posts = new ArrayList<>();

        while (resultSet.next()) {
            if (user.getId().equals(resultSet.getLong(4))) {
                byte[] byteImage = resultSet.getBytes(2);
                String textPost = resultSet.getString(3);
                long idPost = resultSet.getLong(1);
                posts.add(new UserPost(idPost, textPost, byteImage));
            }
        }

        resultSet.close();

        return posts;
    }

    @SneakyThrows
    public List<UserPost> findAllByAccountId(Long id) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        PreparedStatement preparedStatement = connection.prepareStatement("select * from user_post p join user_account u on p.autor_id = u.id where u.id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<UserPost> posts = new ArrayList<>();

        while (resultSet.next()) {
            long idP = resultSet.getLong(1);
            byte[] imageByte = resultSet.getBytes(2);
            String textPost = resultSet.getString(3);
            long idA = resultSet.getLong(5);
            String name = resultSet.getString(6);
            String username = resultSet.getString(7);
            posts.add(new UserPost(idP, textPost, imageByte, new User(idA, name, username)));
        }

        resultSet.close();

        return posts;
    }

    @SneakyThrows
    public void delete (long userId) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("delete from user_post where id = ?");
        preparedStatement.setLong(1, userId);

        preparedStatement.execute();

        preparedStatement.close();

        connection.commit();

    }

}

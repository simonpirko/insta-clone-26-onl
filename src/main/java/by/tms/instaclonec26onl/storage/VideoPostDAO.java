package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserVideoPost;
import lombok.Data;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class VideoPostDAO {
    public void save(UserVideoPost userPost)  {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user_video_post values (default, ?, ?, ?, ? )");
            preparedStatement.setBytes(1, userPost.getVideo());
            preparedStatement.setString(2, userPost.getTitle());
            preparedStatement.setString(3, userPost.getDescription());
            preparedStatement.setLong(4, userPost.getUser().getId());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @SneakyThrows
    public List<UserVideoPost> findAllVideoPostUser(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_video_post");

        List<UserVideoPost> posts = new ArrayList<>();

        while (resultSet.next()) {
             if (user.getId().equals(resultSet.getLong(5))) {
            byte[] byteVideo = resultSet.getBytes(2);
            String title = resultSet.getString(3);
            String description = resultSet.getString(4);
            long id = resultSet.getLong(1);
            posts.add(new UserVideoPost(id, title, description, byteVideo));
            }
        }

        resultSet.close();

        return posts;
    }

        @SneakyThrows
        public List<UserVideoPost> findAllByAccountId(Long id) {
            Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user_video_post p join user_account u on p.autor_id = u.id where u.id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<UserVideoPost> posts = new ArrayList<>();

            while (resultSet.next()) {
                long idP = resultSet.getLong(1);
                byte[] videoByte = resultSet.getBytes(2);
                String title = resultSet.getString(3);
                String description = resultSet.getString(4);

                long idA = resultSet.getLong(5);
                String name = resultSet.getString(6);
                String username = resultSet.getString(7);
                posts.add(new UserVideoPost(idP, title, description, videoByte, new User(idA, name, username)));
            }

            resultSet.close();

            return posts;
        }

    @SneakyThrows
    public void delete (long userId) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");

        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("delete from user_video_post where id = ?");
        preparedStatement.setLong(1, userId);

        preparedStatement.execute();

        preparedStatement.close();

        connection.commit();

    }


}

package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.Comment;
import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.model.UserVideoPost;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCommentStorage {

    public void save_comment (Comment comment)  {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into comment values (default, ?, ?, ?)");
            preparedStatement.setString(1, comment.getComment());
            preparedStatement.setLong(2, comment.getUserPost().getIdPost());
            preparedStatement.setLong(3, comment.getUser().getId());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public List<Comment> findAllByPostId(Long id) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.id, c.comment, c.post_id, c.autor_id " +
                "FROM comment c " +
                "WHERE c.post_id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Comment> comments = new ArrayList<>();

        while (resultSet.next()) {
            long idC = resultSet.getLong(1);
            String comment = resultSet.getString(2);
            long postId = resultSet.getLong(3);
            long autorId = resultSet.getLong(4);
            comments.add(new Comment(idC, comment, new UserPost(postId), new User(autorId)));
        }
        resultSet.close();
        return comments;

    }


    @SneakyThrows
    public List<Comment> findAllComment(UserPost userPost) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test");

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM comment WHERE post_id = ?");
        statement.setLong(1, userPost.getIdPost());
        ResultSet resultSet = statement.executeQuery();

        List<Comment> comments = new ArrayList<>();

        while (resultSet.next()) {
            long idComment = resultSet.getLong(1);
            String comment = resultSet.getString(2);
            comments.add(new Comment(idComment, comment));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return comments;
    }

    @SneakyThrows
    public void deleteComment(Long commentId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from comment where id = ?");
            preparedStatement.setLong(1, commentId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public void deleteCommentByPostId(Long postId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "test");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from comment where post_id = ?");
            preparedStatement.setLong(1, postId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

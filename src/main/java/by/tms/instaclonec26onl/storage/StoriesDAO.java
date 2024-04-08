package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import lombok.SneakyThrows;

import java.sql.*;

public class StoriesDAO {

    @SneakyThrows
    public void addStories(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement addStories = connection.prepareStatement("insert into Stories values (default, ?, ?, ?)");
        addStories.setLong(1, user.getId());
        addStories.setBytes(2, user.getStories());
        addStories.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        addStories.executeUpdate();
        connection.commit();
        addStories.close();
    }
    @SneakyThrows
    public void getStories(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from stories");

        while (resultSet.next()) {
            if (resultSet.getLong(2) == user.getId()) {
                user.setStories(resultSet.getBytes(3));
            }

            connection.commit();
            statement.close();
        }
    }
    @SneakyThrows
    public void deleteStories() {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM Stories WHERE time < (CURRENT_TIMESTAMP - interval '10 hours')");

        connection.commit();
        statement.close();
    }
}

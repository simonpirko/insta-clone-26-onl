package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import lombok.SneakyThrows;

import java.sql.*;

public class DAOStories {

    @SneakyThrows
    public void addStories(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement addStories = connection.prepareStatement("insert into Stories values (default, ?, ?)");
        addStories.setLong(1, user.getId());
        addStories.setBytes(2, user.getStories());

        addStories.executeUpdate();

        addStories.close();

        connection.commit();
    }
    @SneakyThrows
    public void getStories(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from stories");

        while (resultSet.next()){
            if (resultSet.getLong(2) == user.getId()) {
                user.setStories(resultSet.getBytes(3));

            }
           // resultSet.close(); (если закрыть, не запускается сервлет)
            connection.commit();
        }
    }
}

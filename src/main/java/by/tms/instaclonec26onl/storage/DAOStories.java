package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOStories {
    private final UserService userService = new UserService();
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
}

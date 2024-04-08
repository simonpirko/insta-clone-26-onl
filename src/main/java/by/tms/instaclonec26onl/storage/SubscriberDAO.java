package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;
import lombok.SneakyThrows;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriberDAO {

    private final UserService userService = new UserService();

    @SneakyThrows
    public void addUserSub (User follower, User subscribe) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("insert into subscribers values (default, ?, ?)");

        preparedStatement.setLong(1, follower.getId());
        preparedStatement.setLong(2, subscribe.getId());

        preparedStatement.execute();
        preparedStatement.close();

        connection.commit();

    }

    @SneakyThrows
    public void unSubUser (User fol, User sub) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("delete from subscribers where follower = ? and subscribe = ?");

        preparedStatement.setLong(1, fol.getId());
        preparedStatement.setLong(2, sub.getId());

        preparedStatement.execute();
        preparedStatement.close();

        connection.commit();

    }

    @SneakyThrows
    public List<User> findSubUser(long id) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from subscribers");

        List<User> userList = new ArrayList<>();

        while (resultSet.next()){
            if (resultSet.getLong(2) == id) {
                long idSub = resultSet.getLong(3);

                User user = userService.findUserById(idSub);

                userList.add(user);

            }
        }

        resultSet.close();

        connection.commit();

        return userList;

    }

    @SneakyThrows
    public List<User> findFollowerUser (long id) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from subscribers");

        List<User> userList = new ArrayList<>();

        while (resultSet.next()) {
            if (resultSet.getLong(3) == id) {
                long idSub = resultSet.getLong(2);

                User user = userService.findUserById(idSub);

                userList.add(user);

            }
        }

        resultSet.close();

        connection.commit();

        return userList;

    }

}

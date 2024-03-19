package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import lombok.SneakyThrows;
import java.sql.*;

public class InMemorySubStorage {

    @SneakyThrows
    public void addUserSub (User user) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("insert into subscription values (default, ?)");

        preparedStatement.setInt(1, Math.toIntExact(user.getId()));

        preparedStatement.execute();
        preparedStatement.close();

        connection.commit();

    }

    @SneakyThrows
    public void subscribeByIdUser (User sub) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement preparedStatement = connection.prepareStatement("update subscription set user_sub_id = ?");

        preparedStatement.setLong(1, sub.getId());

        preparedStatement.close();

        connection.commit();


    }

}

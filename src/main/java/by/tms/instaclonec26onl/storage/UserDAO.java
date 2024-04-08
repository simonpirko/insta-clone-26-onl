package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.model.User;
import lombok.SneakyThrows;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    @SneakyThrows
    public List<User> findAllUser() {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_account");

        List<User> userList = new ArrayList<>();

        while (resultSet.next()){

            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            String username = resultSet.getString(3);

            userList.add(new User(id, name, username));
        }

        resultSet.close();
        connection.commit();

        return userList;
    }

    @SneakyThrows
    public void save(User user){
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement addUser = connection.prepareStatement("insert into user_account values (default, ?, ?, ?)");

        addUser.setString(1, user.getName());
        addUser.setString(2, user.getUsername());
        addUser.setString(3, user.getPassword());

        addUser.execute();

        addUser.close();

        connection.commit();
    }

    @SneakyThrows
    public User findUserByUsername(String username) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_account");

        while (resultSet.next()){
            if (resultSet.getString(3).equals(username)) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                byte[] avatar = resultSet.getBytes(5);

                resultSet.close();

                connection.commit();
                return new User(id, name, username, password, avatar);
            }
        }

        return new User();

    }

    @SneakyThrows
    public User findUserById (long id) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_account");
        User user = new User();

        while (resultSet.next()){
            if (resultSet.getLong(1) == id) {
                String name = resultSet.getString(2);
                String username = resultSet.getString(3);

                user.setId(id);
                user.setName(name);
                user.setUsername(username);

                break;
            }
        }

        resultSet.close();

        connection.commit();

        return user;

    }

    @SneakyThrows
    public void update(User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement updateUser = connection.prepareStatement("update user_account set username = ?, password = ? where id = ?");

        updateUser.setString(1, user.getUsername());
        updateUser.setString(2, user.getPassword());
        updateUser.setLong(3, user.getId());

        updateUser.executeUpdate();

        updateUser.close();

        connection.commit();
    }

    @SneakyThrows
    public void updateAvatar(User user) {

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement updateUser = connection.prepareStatement("update user_account set avatar = ? where id = ?");

        updateUser.setBytes(1, user.getProfilePicture());
        updateUser.setLong(2, user.getId());

        updateUser.executeUpdate();

        updateUser.close();

        connection.commit();

    }

    public void delete(User user) {
        //users.remove(user.getUsername());
    }


}

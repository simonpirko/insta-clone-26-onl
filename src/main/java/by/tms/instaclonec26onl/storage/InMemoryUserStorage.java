package by.tms.instaclonec26onl.storage;

import by.tms.instaclonec26onl.custom_exceptions.UserNotFoundException;
import by.tms.instaclonec26onl.model.User;
import lombok.SneakyThrows;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Типа БД
public class InMemoryUserStorage {
    //private final static Map<String, User> users = new ConcurrentHashMap<>();
    //private final static List<String> listUsername = new ArrayList<>();

    // сохранение в Map
    /*public static void save(User user) {
        users.computeIfAbsent(user.getUsername(), k -> user);
    }*/

    @SneakyThrows
    public List<User> findAllUser() {
        /*List<User> list = users.values().stream().toList();
        for (User user : list) {
            listUsername.add(user.getUsername());
        }*/
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
        /*User user = users.get(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }*/

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user_account");

        while (resultSet.next()){
            if (resultSet.getString(3).equals(username)) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(4);

                resultSet.close();

                connection.commit();
                return new User(id, name, username, password);
            }
        }

        return new User();

    }

    @SneakyThrows
    public void changeCredsUser (User user) {
        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        connection.setAutoCommit(false);

        PreparedStatement updateUser = connection.prepareStatement("update user_account set username = ?, password = ? where id = ?");

        updateUser.setString(1, user.getUsername());
        updateUser.setString(2, user.getPassword());
        updateUser.setLong(3, user.getId());

        updateUser.executeUpdate();

        connection.commit();

    }

    public void delete(User user) {
    }
}

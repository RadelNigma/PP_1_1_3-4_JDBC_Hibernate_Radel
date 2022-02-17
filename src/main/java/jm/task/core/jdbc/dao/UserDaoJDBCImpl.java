package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "CREATE TABLE IF NOT EXISTS Users(" +
                    "id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name varchar(50)," +
                    " lastName varchar(50)," +
                    " age int)";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "DROP TABLE IF EXISTS Users";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "INSERT INTO Users VALUES(" + null + ",'" + name + "','"
                    + lastName + "'," + age + ")";
            statement.executeUpdate(SQL);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "DELETE FROM Users WHERE id=" + (int) id;
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));

                userList.add(user);
            }
            System.out.println(userList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            String SQL = "DELETE FROM Users";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

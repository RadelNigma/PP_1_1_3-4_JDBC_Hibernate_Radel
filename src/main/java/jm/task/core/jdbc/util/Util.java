package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata_radel";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "FFpe43FFpe43";

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Успешное подключение к базе данных " + URL + "!");
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных " + URL + "!");
            System.out.println(e);
        }
    }
}

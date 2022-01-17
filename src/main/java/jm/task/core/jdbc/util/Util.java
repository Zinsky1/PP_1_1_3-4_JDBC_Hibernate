package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String nameUser = "root";
    public static final String password = "root";

    public static final String url = "jdbc:mysql://localhost:3306/for";

    public static Connection getConnection() throws SQLException, ClassCastException {
        Connection connection = DriverManager.getConnection(url, nameUser, password);
        System.out.println("Connected!");
        return connection;

    }
}

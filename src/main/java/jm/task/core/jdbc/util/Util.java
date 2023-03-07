package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

    public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();


                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                System.out.println("Connected to Hibernate");
            } catch (Exception e) {
                System.out.println("Исключение при создании сессии: " + e);
            }
        }
        return sessionFactory;
    }
}

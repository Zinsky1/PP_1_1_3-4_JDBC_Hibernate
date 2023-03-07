package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255) NOT NULL, " +
                "lastName VARCHAR(255) NOT NULL, " +
                "age INT)";
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            System.out.println("Таблица 'user' успешно создана");
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS user";
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("Таблица 'user' удалена");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO user (name, lastName, age) VALUES (?,?,?);";
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql)
                    .setParameter(1, name)
                    .setParameter(2, lastName)
                    .setParameter(3, age).executeUpdate();
            transaction.commit();
            System.out.println("Пользователь " + name + " " +
                    lastName  + " сохранён");
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
       String sql = "DELETE FROM user WHERE id=?;";
       try(Session session = Util.getSessionFactory().openSession()) {
           Transaction transaction = session.beginTransaction();
           session.createSQLQuery(sql).setParameter(1, id).executeUpdate();
           transaction.commit();
           System.out.println("Пользователь с ID " + id + " удалён");
       } catch (HibernateException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user;";
        return (List<User>) Util.getSessionFactory()
                .openSession().createSQLQuery(sql).list();

    }

    @Override
    public void cleanUsersTable() {
        String sql = "DELETE FROM user;";
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            System.out.println("Таблица 'user' очищена");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}

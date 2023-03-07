package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoJDBCImpl();
    UserDao hiberDao = new UserDaoHibernateImpl();
    public void createUsersTable() {
        //userDao.createUsersTable();
        hiberDao.createUsersTable();
    }

    public void dropUsersTable() {
        //userDao.dropUsersTable();
        hiberDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        //userDao.saveUser(name, lastName, age);
        hiberDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        //userDao.removeUserById(id);
        hiberDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        //return userDao.getAllUsers();
        return hiberDao.getAllUsers();
    }

    public void cleanUsersTable() {
        //userDao.cleanUsersTable();
        hiberDao.cleanUsersTable();
    }
}

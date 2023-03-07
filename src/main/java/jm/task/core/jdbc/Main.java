package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();



        userService.createUsersTable();

        userService.saveUser("john ", "Smith", (byte) 32);
        userService.saveUser("Adam ", "Paris", (byte) 23);
        userService.saveUser("Carl ", "Cooper", (byte) 51);
        userService.saveUser("Mickael ", "Hook", (byte) 21);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();



    }
}

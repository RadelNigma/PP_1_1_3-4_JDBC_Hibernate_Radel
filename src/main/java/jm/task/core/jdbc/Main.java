package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Юрий", "Гагарин", (byte) 34);
        userService.saveUser("Иван", "Крылов", (byte) 100);
        userService.saveUser("Оксана", "Фёдорова", (byte) 44);
        userService.saveUser("Paul", "McCartney", (byte) 78);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}

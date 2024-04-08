package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;

import java.util.List;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("John", "Smith", (byte) 23);
        userService.saveUser("William", "Johns", (byte) 51);
        userService.saveUser("Adam", "Smith", (byte) 45);
        userService.saveUser("Jane", "Williams", (byte) 21);
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

package jm.task.core.jdbc;

import com.mysql.cj.Session;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        // реализуйте алгоритм здесь


        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println(" ");

        userService.saveUser("Leha", "Berezhnov", (byte) 27);
        userService.saveUser("Sanya", "Boev", (byte) 28);
        userService.saveUser("Roman", "Shkapov", (byte) 27);
        userService.saveUser("Chelovek", "Noname", (byte) 18);
        System.out.println(" ");

        userService.removeUserById(1);
        System.out.println("");

        userService.getAllUsers();
        System.out.println(" ");

        userService.cleanUsersTable();
        System.out.println(" ");

        userService.dropUsersTable();
        System.out.println(" ");



    }
}

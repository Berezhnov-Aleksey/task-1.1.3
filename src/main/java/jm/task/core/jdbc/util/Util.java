package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL= "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "6479";



    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("connect is okey");
            System.out.println(" ");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("connect is not okey");
        }
        return connection;
    }






}

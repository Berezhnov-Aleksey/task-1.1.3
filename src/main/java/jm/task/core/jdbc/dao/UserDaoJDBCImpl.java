package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    " id SERIAL PRIMARY KEY," +
                    " firstname CHARACTER VARYING(20)," +
                    " lastname CHARACTER VARYING(20)," +
                    " age INTEGER" + ");");
            System.out.println("sozdal bd");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void dropUsersTable() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("DROP TABLE IF EXISTS users;");
            System.out.println("udalil bd");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("INSERT INTO users (firstname, lastname, age) VALUES ('" +
                    name + "','" + lastName + "'," + age + ");");
            System.out.println(" name:" + name + " lastname: " + lastName + " dobavlen v bd");
        } catch (SQLException e) {
            //throw new RuntimeException();
        }
    }

    public void removeUserById(long id) {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("DELETE FROM users WHERE id = " + id + ";");
            System.out.println("User: " + id + " udalen");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users")) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                byte age = rs.getByte("age");
                users.add(new User(name, lastName, age));
                System.out.println(rs.getLong(1) + ", " + rs.getString(2) + ", " +
                        rs.getString(3) + ", " + rs.getByte(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement st = connection.createStatement()) {
            st.executeUpdate("TRUNCATE TABLE users");
            System.out.println("ochistil bd");
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }
}

package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()) {

                System.out.println("Connection to mydbtest was succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException {

        Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "12345" );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return conn;
    }
}

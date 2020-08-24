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

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Users\\FOLIO\\Desktop\\CoreTaskTemplate-master\\src\\main\\java\\resourses\\database.properties"))) {
            props.load(in);
        }

            String url = props.getProperty("db.host");
            String username = props.getProperty("db.login");
            String password = props.getProperty("db.password");

            return DriverManager.getConnection(url, username, password);


    /*static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection;
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest", "root", "12345" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/


    }
}

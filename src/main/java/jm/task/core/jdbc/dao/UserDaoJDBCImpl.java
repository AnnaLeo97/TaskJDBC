package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() throws IOException, SQLException {
    }

    public void createUsersTable() throws SQLException, IOException {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);


            String SQL = "CREATE TABLE user" +
                    "(id INTEGER not NULL AUTO_INCREMENT," +
                    " name VARCHAR(50) not NULL, " +
                    " lastName VARCHAR (50) not NULL, " +
                    " age INTEGER not NULL, " +
                    " PRIMARY KEY (id))";


            statement = connection.prepareStatement(SQL);
            statement.execute();

            System.out.println("Таблица создана!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void dropUsersTable() throws IOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            String SQL = "DROP TABLE user";

            statement = connection.prepareStatement(SQL);
            statement.execute();
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws IOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            String SQL = "INSERT INTO user (name, lastName, age)" +
                        "VALUES(?, ?, ?)";

            statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);

            statement.executeUpdate();
            //System.out.println("Пользователь добавлен");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) throws IOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            String SQL = "SELECT * FROM user WHERE id = :id; DROP VIEW;";

            statement = connection.prepareStatement(SQL);
            statement.executeUpdate();
            System.out.println("Ненужные id, вероятно, удалены");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public List<User> getAllUsers() throws IOException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rs;
        List<User> result = new ArrayList<>();

        try {

            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement("SELECT id, name, lastName, age FROM user");
            rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                User user = new User(id);
                user.setName(name);
                user.setLastName(lastName);
                user.setAge((byte) age);
                result.add(user);
            }
            connection.commit();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

        public void cleanUsersTable() throws SQLException, IOException{
            Connection connection = getConnection();
            PreparedStatement statement = null;

            try {
                connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                connection.setAutoCommit(false);


                String sql = "TRUNCATE TABLE user";
                statement = connection.prepareStatement(sql);
                statement.execute();

                System.out.println("Таблица очищена священным пламенем инквизиции. AVE MARIA, DEUS VULT!");
            } catch (SQLException e) {
                    e.printStackTrace();
            } finally {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }


        }

    }
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    void createUsersTable() throws ClassNotFoundException, SQLException, IOException;

    void dropUsersTable() throws IOException, SQLException;

    void saveUser(String name, String lastName, byte age) throws IOException, SQLException;

    void removeUserById(long id) throws IOException, SQLException;

    List<User> getAllUsers() throws IOException, SQLException;

    void cleanUsersTable() throws SQLException, IOException;
}

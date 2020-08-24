package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDaoJDBCImpl userDao;

    static {
        try {
            userDao = new UserDaoJDBCImpl();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createUsersTable() throws SQLException, ClassNotFoundException, IOException {
        userDao.createUsersTable();
    }

    public void dropUsersTable() throws IOException, SQLException {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws IOException, SQLException {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws IOException, SQLException {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() throws IOException, SQLException {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException, IOException {
        userDao.cleanUsersTable();
    }
}

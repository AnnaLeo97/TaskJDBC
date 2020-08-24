package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable(); // Создание таблицы User(ов)

        userService.saveUser("Borya", "Smith", (byte)18); // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        System.out.println("User с именем Borya добавлен в базу данных"); //После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        userService.saveUser("Varya", "Smith", (byte)22); // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        System.out.println("User с именем Varya добавлен в базу данных"); //После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        userService.saveUser("Phima", "Smith", (byte)78); // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        System.out.println("User с именем Phima добавлен в базу данных"); //После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
        userService.saveUser("Gytya", "Smith", (byte)90); // Добавление 4 User(ов) в таблицу с данными на свой выбор.
        System.out.println("User с именем Gytya добавлен в базу данных"); //После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )


        for (User user: userService.getAllUsers()) {
            System.out.println(user.toString());
        }// Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)

        userService.cleanUsersTable(); // Очистка таблицы User(ов)
        userService.dropUsersTable(); // Удаление таблицы


    }
}

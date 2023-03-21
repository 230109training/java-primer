package com.revature;

import com.revature.dao.UserDao;
import com.revature.model.User;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        try {
//            List<User> allUsers = userDao.getAllUsers();

            // "Enhanced for loop"
            // Anything that inherits the "Iterable" interface in Java can be utilized using an enhanced for loop
//            for (User u : allUsers) {
//                System.out.println(u);
//            }

//            User newUser = new User("testing123", "pass12345", "test", "test", "test@email.com", 50, null);
//            userDao.addUser(newUser);

            User user = userDao.getUserByUsernameAndPassword("bach_tran123", "password123");
            System.out.println(user);
        } catch(SQLException e) {
            e.printStackTrace();
        }

    }

}

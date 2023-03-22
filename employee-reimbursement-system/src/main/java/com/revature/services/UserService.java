package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.exceptions.InvalidLoginException;
import com.revature.exceptions.InvalidParameterException;
import com.revature.exceptions.UsernameAlreadyTakenException;
import com.revature.model.User;
import com.revature.model.UserPayload;
import com.revature.utility.JWTUtility;

import java.sql.SQLException;

public class UserService {

    // Dependencies
    private UserDAO userDao = new UserDAO();

    // return a JWT
    public String login(String username, String password) throws SQLException, InvalidLoginException {
        // Get User from database
        // -> If user doesn't exist, throw exception
        User user = userDao.getUserByUsernameAndPassword(username, password);

        if (user == null) {
            throw new InvalidLoginException("Invalid username and/or password");
        }

        // Generate JWT
        UserPayload payload = new UserPayload(user.getUsername(), user.getRole());
        String token = JWTUtility.createToken(payload);
        return token;
    }

    public void registerNewUser(User userToAdd) throws SQLException, InvalidParameterException, UsernameAlreadyTakenException {
        // Validating business logic goes here
        if (userToAdd.getFirstName().length() < 4) {
            throw new InvalidParameterException("First name must have a length of 4 or greater");
        }

        if (userToAdd.getLastName().length() < 4) {
            throw new InvalidParameterException("Last name must have a length of 4 or greater");
        }

        // Check if user with username already exists
        if (userDao.getUserByUsername(userToAdd.getUsername()) != null) {
            throw new UsernameAlreadyTakenException("Username already exists");
        }

        // Call DAO method to add user to DB
        userDao.addUser(userToAdd);
    }

}

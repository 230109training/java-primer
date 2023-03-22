package com.revature.dao;

import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void addUser(User user) throws SQLException {
        Connection con = ConnectionUtility.getConnection();

        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO users (username, password, first_name, last_name, email, age)" +
                        " VALUES (?, ?, ?, ?, ?, ?)");

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getFirstName());
        pstmt.setString(4, user.getLastName());
        pstmt.setString(5, user.getEmail());
        pstmt.setInt(6, user.getAge());

        int recordsInserted = pstmt.executeUpdate(); // DML operations (INSERT, UPDATE, DELETE)
    }

    public User getUserByUsername(String username) throws SQLException {
        Connection con = ConnectionUtility.getConnection();

        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
        pstmt.setString(1, username);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String un = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            String role = rs.getString("role");

            User user = new User(un, password, firstName, lastName, email, age, role);

            return user;
        } else {
            return null;
        }
    }

}

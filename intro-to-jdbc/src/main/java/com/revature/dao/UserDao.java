package com.revature.dao;

import com.revature.model.User;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> getAllUsers() throws SQLException {
        // 1. Register the Postgres driver with JDBC
        Driver postgresDriver = new Driver();

        DriverManager.registerDriver(postgresDriver);

        // 2. Create a Connection object
        // url = connection string
        // jdbc:postgresql://<host>:5432/<db name>
        Connection con = DriverManager.getConnection("jdbc:postgresql://database-1.cifwcr7ybkhx.us-east-1.rds.amazonaws.com:5432/postgres",
                "postgres", "password");

        // 3. Create a PreparedStatement object from the connection object's prepareStatement method
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");

        // 4. Execute Query to get a ResultSet object
        ResultSet rs = pstmt.executeQuery();

        List<User> users = new ArrayList<>();
        // 5. Iterate through the ResultSet
        while (rs.next()) { // rs.next() will retrieve the next result and return true (if there is a next result)
            // otherwise rs.next() will return false
            String username = rs.getString("username");
            String password = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            String role = rs.getString("role");

            User user = new User(username, password, firstName, lastName, email, age, role);

            users.add(user); // add user object to the ArrayList
        }

        return users;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        Driver postgresDriver = new Driver();

        DriverManager.registerDriver(postgresDriver);

        Connection con = DriverManager.getConnection("jdbc:postgresql://database-1.cifwcr7ybkhx.us-east-1.rds.amazonaws.com:5432/postgres",
                "postgres", "password");

        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users u WHERE u.username = ? AND u.password = ?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();
        // Here we don't need to use a while loop to iterate through the ResultSet
        // Because we only expect to get 0 or 1 results from the given query
        if (rs.next()) { // we have 1 result
            String un = rs.getString("username");
            String pw = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            String role = rs.getString("role");

            User user = new User(un, pw, firstName, lastName, email, age, role);

            return user;
        } else { // we got 0 results
            return null;
        }
    }

    public void addUser(User user) throws SQLException {
        Driver postgresDriver = new Driver();

        DriverManager.registerDriver(postgresDriver);

        Connection con = DriverManager.getConnection("jdbc:postgresql://database-1.cifwcr7ybkhx.us-east-1.rds.amazonaws.com:5432/postgres",
                "postgres", "password");

        PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO users (username, password, first_name, last_name, email, age)" +
                " VALUES (?, ?, ?, ?, ?, ?)");

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getFirstName());
        pstmt.setString(4, user.getLastName());
        pstmt.setString(5, user.getEmail());
        pstmt.setInt(6, user.getAge());

        int recordsInserted = pstmt.executeUpdate();
        System.out.println(recordsInserted); // should be 1
    }

}

package com.revature.utility;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    public static Connection getConnection() throws SQLException {
        Driver postgresDriver = new Driver();

        DriverManager.registerDriver(postgresDriver);

        Connection con = DriverManager.getConnection("jdbc:postgresql://database-1.cifwcr7ybkhx.us-east-1.rds.amazonaws.com:5432/postgres",
                "postgres", "password");

        return con;
    }
}

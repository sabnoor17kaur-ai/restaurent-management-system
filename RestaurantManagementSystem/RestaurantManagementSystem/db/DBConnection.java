package db;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant_db";  // Change DB name if needed
    private static final String USER = "root";  // Replace with your DB username
    private static final String PASS = "root"; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
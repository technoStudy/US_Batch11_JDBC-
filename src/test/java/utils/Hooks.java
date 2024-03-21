package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.*;

public class Hooks {

    public static Statement statement;
    public static Connection connection;
    public static ResultSet resultSet;
    public static String databaseUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com :3306/batch11?serverTimezone=UTC";
    // public static String databaseUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com :3306/sakila?serverTimezone=UTC";
    public static String username = "root";
    public static String password = "'\"-LhCB'.%k[4S]z";

    @BeforeMethod
    public void setUp() {
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

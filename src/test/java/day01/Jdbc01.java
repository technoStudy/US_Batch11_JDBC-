package day01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc01 {

    // We should create jdbc components to test
    // 1st JDBC component is Statement interface
    /*
    Statement statement;
    -- using for
    1- Sending SQL Query
    2- Executing Queries
    3- Modifying Data
    4- Security
     */
    Statement statement ;
    // 2nd JDBC Component is Connection interface
    /*
    Using for
    1- Establishing Communication
    2- Creating Statements
    3- Transactions Management
    4- Resource Management
     */
    Connection connection;
    // 3rd JDBC Component is ResultSet interface
    /*
    using for
    1- Storing Query Result
    2- Accessing Data
    3- Processing Query Result
     */
    ResultSet resultSet;


    // to connect database we need to create following variables
    String databaseUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com :3306/batch11?serverTimezone=UTC";
    String username = "root";
    String password = "'\"-LhCB'.%k[4S]z";

    @Test
    public void schoolTableView() throws SQLException {
        // connection ==>> statement ===> resultSet
        connection = DriverManager.getConnection(databaseUrl,username,password);
        statement = connection.createStatement();
        resultSet=statement.executeQuery("select * from school");
        // we created db connection

        // reading data with resultSet.next(), and it is searching data within table
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2)
            +" "+resultSet.getString(3)+" "+resultSet.getInt(4));
        }
    }
    @Test
    public void theSumOfWorkingHoursSchoolTable() throws SQLException {
        connection = DriverManager.getConnection(databaseUrl,username,password);
        statement = connection.createStatement();
        resultSet=statement.executeQuery("select sum(working_hours_weekly) from school");

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }
    }

    @Test
    public void factoryTableView() throws SQLException {
        connection = DriverManager.getConnection(databaseUrl,username,password);
        statement=connection.createStatement();
        resultSet= statement.executeQuery("select * from factory");

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " "+resultSet.getString(2)
                    +" "+resultSet.getString(3)+" "+resultSet.getDouble(4));
        }
    }

    @Test
    public void creatYourOwnTable() throws SQLException {
        connection = DriverManager.getConnection(databaseUrl,username,password);
        statement=connection.createStatement();

        String createTable = "create table mehmetTable(\n" +
                "team_id int,\n" +
                "teamName varchar(20)\n" +
                ");";

        statement.execute(createTable);
    }

    @AfterMethod
    public void tearDown(){
        try {
            if(statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }








}

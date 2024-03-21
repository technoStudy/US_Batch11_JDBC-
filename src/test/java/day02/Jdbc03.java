package day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Hooks;
import utils.SQLqueries;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc03 extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();

    @Test
    public void priceTestFactoryTable() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.totalAmountPriceFactoryTable());
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
        }
    }

    // If resultSet returns a one unique data we can use if condition instead of while
    @Test
    public void priceTest() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.totalAmountPriceFactoryTable());

        int actualPrice = 0;
        if (resultSet.next()) {
            actualPrice = resultSet.getInt(1);
            System.out.println(actualPrice);
        }
        Assert.assertEquals(actualPrice, 571);
    }


    // For this test the sakila DB is used
    // Test the number of film is greater than 1000
    @Test
    public void numberOfFilmSakila() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.totalNumberofFilmSakila());
        //"select count(title) from film"
        // resultSet will return an integer value we can use if condition

        int actualResult = 0;
        if (resultSet.next()) {
            actualResult = resultSet.getInt(1);
            System.out.println(actualResult);
        }
        Assert.assertTrue(actualResult > 1000);

    }

    // Verify that Aslanbek exists in the people table
    @Test
    public void schoolTable() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.teacherNameSchoolTable("Asli"));
        // resultSet will return teacher_name column

        // resultSet might be return more than one data thats why it is better to put them in a list
        List<List<Object>> tableData = new ArrayList<>();

        while (resultSet.next()) {
            List<Object> rowData = new ArrayList<>();
            rowData.add(resultSet.getString(1));
            tableData.add(rowData);
        }
        // to check is the data exist or not we should create boolean variable
        boolean isDataFound = false;
        for (List<Object> rowData :tableData){
            if(rowData.contains("Asli")){
                isDataFound = true;
                break;
            }
        }
        Assert.assertEquals(isDataFound,true);
    }

    // Verify that Gold,Platinum,Steel,iron,silver exist in the database
    // DataProvider




}



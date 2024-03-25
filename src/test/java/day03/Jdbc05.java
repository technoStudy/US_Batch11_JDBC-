package day03;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Hooks;
import utils.SQLqueries;
import utils.TestData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc05 extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();
    // List the all data of the personel whose position ends with er

    //select position from personnel where position like '%er' ;

    // Retrieving Data
    @Test
    public void listAllSpecificData() throws SQLException {
        // select position from personnel where position like '%er'
        resultSet = statement.executeQuery(sqLqueries.listPositionDataPersonnelTable());

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }

    // Testing for one data
    @Test
    public void isPositionExistsPersonnelTable() throws SQLException {
        // select position from personnel where position like '%er'
        resultSet = statement.executeQuery(sqLqueries.listPositionDataPersonnelTable());
        List<List<Object>> tableData = new ArrayList<>();

        while (resultSet.next()) {
            List<Object> rowData = new ArrayList<>();
            rowData.add(resultSet.getString(1));
            tableData.add(rowData);
        }
        String expectedData = "Machine Learning Developer";
        boolean isDataFound = false;

        for (List<Object> rowData : tableData) {
            if (rowData.contains(expectedData)) {
                isDataFound = true;
                break;
            }
        }
        Assert.assertEquals(true, isDataFound);
    }

    // Testing for many data we can use data provider
    // create dataprovider method in the TestData Class

    @Test(dataProvider = "positions", dataProviderClass = TestData.class)
    public void positionTest(String expectedPosition) throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.listPositionDataPersonnelTable());
        // create inner list with name tableData
        List<List<Object>> tableData = new ArrayList<>();

        // while loop and create one more list in the while loop
        while (resultSet.next()){
            List<Object> rowData = new ArrayList<>();
            rowData.add(resultSet.getString(1));
            tableData.add(rowData);
        }
        // default value should be false because we will make it true if data exists
        boolean isDataFound = false;

        // to read list we need to create for each loop
        for (List<Object> rowData:tableData){
            if(rowData.contains(expectedPosition)){
                isDataFound = true;
                break;
            }
        }
        Assert.assertEquals(true, isDataFound);
    }


}

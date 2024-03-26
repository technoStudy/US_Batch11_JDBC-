package utils;


import org.testng.Assert;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();

    // creating dynamic method to count number of null data
    public int countNullCellsInTable(String tableName) {
        int nullCellCount = 0;

        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqLqueries.readingTableData(tableName));
            // ResulSetMetData is an interface provides information about columns in a table,such as column name,
            // column types, number of columns...e
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    if (resultSet.getObject(i) == null) {
                        nullCellCount++;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(nullCellCount);
        return nullCellCount;
    }

    // If we are looking a data within a column
    public void checkDataExistInColumn(String data, String columnName, String tableName) {
        List<List<Object>> tableData = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqLqueries.readingDataFromColumnInTable(columnName, tableName));
            while (resultSet.next()) {
                List<Object> rowData = new ArrayList<>();
                rowData.add(resultSet.getString(1));
                tableData.add(rowData);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        boolean isDataFound = false;

        for (List<Object> rowData : tableData) {
            if (rowData.contains(data)) {
                isDataFound = true;
                break;
            }
        }
        Assert.assertEquals(isDataFound, true);
    }



    // If we need to verify the sum of an int,double column in a table
    public void sumOfColumnInTable(String expectedData,String columnName, String tableName){
        int actualPrice = 0;
        try {
            connection = DriverManager.getConnection(databaseUrl, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqLqueries.sumOfColumnData(columnName,tableName));
            if (resultSet.next()) {
                actualPrice = resultSet.getInt(1);
                System.out.println(actualPrice);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        Assert.assertEquals(actualPrice,expectedData );
    }


}

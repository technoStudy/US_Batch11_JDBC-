package day03;

import org.testng.annotations.Test;
import utils.Hooks;
import utils.SQLqueries;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Jdbc06 extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();
    //Sometimes we can not see data in the cell in a table, it measn there is a null data
    // Count the number of null data

    @Test
    public void countNullCellsInSchoolTable() throws SQLException {
        // create a int variable to assign null data
        int nullCellCount = 0;
        resultSet = statement.executeQuery(sqLqueries.readingTableData("school"));
        while (resultSet.next()){
            // ResultSetMetaData is anninterface provides information about columns in a table
            // such as column name, column types, number of columns
            // create object from ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i =1 ; i<= columnCount;i++){
                if(resultSet.getObject(i)==null){
                    nullCellCount++;
                }
            }
        }
        System.out.println("The Number of Null Data : "+nullCellCount);
    }


}

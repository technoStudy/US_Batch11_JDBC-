package day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Hooks;
import utils.SQLqueries;
import utils.TestData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc04 extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();

    // verify that it matched the id with material_name
    @Test(dataProvider = "materialName", dataProviderClass = TestData.class)
    public void materialNameProductTable(int id,String materialName) throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.factoryTableIDName(id));
        List<List<Object>> tableData = new ArrayList<>();

        while (resultSet.next()){
            List<Object> rowData = new ArrayList<>();
            rowData.add(resultSet.getString(1));
            tableData.add(rowData);
        }
        boolean isDataExist = false;

        for(List<Object>rowData:tableData){
            if (rowData.contains(materialName));
            isDataExist = true;
            break;
        }
        Assert.assertEquals(isDataExist,true);
    }


    public static int getStringLength(String inputString) {
        return inputString.length();
    }

    public static void main(String[] args) {
        String inputStr = "";
        int length = getStringLength(inputStr);
        System.out.println("The length of the string is: " + length);
    }



}

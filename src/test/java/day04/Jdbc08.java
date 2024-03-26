package day04;

import org.testng.annotations.Test;
import utils.JdbcUtils;
import utils.TestData;

public class Jdbc08 {

    JdbcUtils jdbcUtils = new JdbcUtils();
    @Test
    public void isCustomerExist(){
        jdbcUtils.checkDataExistInColumn("Olivia Martinez","customer_name","market");
    }


    @Test(dataProvider = "customerName",dataProviderClass = TestData.class)
    public void customerTest(String customeName){
        jdbcUtils.checkDataExistInColumn(customeName,"customer_name","market");
    }

    @Test(dataProvider = "workersName", dataProviderClass = TestData.class)
    public void nameWorkersExist(String nameWorkers){
        jdbcUtils.checkDataExistInColumn(nameWorkers,"name","workers");
    }


    @Test
    public void sumOfPriceInMarket(){
        jdbcUtils.sumOfColumnInTable(344,"price","market");
    }

    @Test
    public void sumOfAgeStudents(){
        jdbcUtils.sumOfColumnInTable(980,"age","students");

    }


    @Test
    public void averageOfStudentsAge(){
        jdbcUtils.averageColumnInTable(57,"age","students");
    }
}

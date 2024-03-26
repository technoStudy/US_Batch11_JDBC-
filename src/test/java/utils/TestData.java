package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name="materialName")
    public Object[][] provideMatrialData(){
        return new Object[][]{
                {112,"iron"},
                {113,"silver"},
                {114,"Steel"},
                {115,"Gold"},
                {116,"copper"},

        };
    }

    @DataProvider(name="positions")
    public Object [][] positionDataTest(){
        return new Object[][]{
                {"Automation Tester"},
                {"Manual Tester"},
                {"Developer"},
                {"Accounter"},
                {"Machine Learning Developer"}
        };
    }

    @DataProvider(name="customerName")
    public Object [][] customerDataTest(){
        return new Object[][]{
                {"John Doe"},
                {"Jane Smith"},
                {"Emily Jones"},
                {"Michael Brown"},
                {"Jessica Davis"},
                {"William Wilson"},
                {"Olivia Martinez"},
                {"Henry Taylor"},
                {"Sophia Anderson"},
                {"Isabella Thomas"}
        };
    }

    @DataProvider(name="workersName")
    public Object [][] workersNameDataTest(){
        return new Object[][]{
                {"Aliye"},
                {"Hanna"},
                {"Tetiana"},
                {"Hamza"},
                {"Sahin"},
                {"Aziza"},
                {"Mehmet"},
                {"Khalid"},
                {"Samet"},
                {"Aslanbek"},
                {"Polina"},
                {"Vafa"}
        };
    }


}

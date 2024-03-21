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
                {116,"Platinum"}
        };
    }



}

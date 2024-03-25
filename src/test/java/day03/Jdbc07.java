package day03;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Hooks;
import utils.JdbcUtils;

import java.sql.SQLException;

public class Jdbc07 {

    // we will use in this class methods from the JdbcUtils thats why we do not need to extend Hooks
    // because JdbcUtils extended Hooks

    JdbcUtils jdbcUtils = new JdbcUtils();

    @Test
    public void nullCellDataTestScoolTable() {

       Assert.assertEquals(jdbcUtils.countNullCellsInTable("school"),7);

    }


}

package day01;

import org.testng.annotations.Test;
import utils.Hooks;
import utils.SQLqueries;

import java.sql.SQLException;

public class Jdbc02 extends Hooks {

    SQLqueries sqLqueries = new SQLqueries();

    @Test
    public void teacherNameView() throws SQLException {
        resultSet = statement.executeQuery("select teacher_name from school where lesson = 'TestNG'");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }


    @Test
    public void specificTeacherName() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.schoolTableTeacherName("Azamat"));
        //schoolTableTeacherName("Aslanbek") ==> select teacher_name from school where teacher_name='Aslanbek'
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }


    @Test
    public void numberOfTeacherTest() throws SQLException {
        resultSet = statement.executeQuery(sqLqueries.numberOfTeacherSchoolTable());
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }
    }


}

package utils;

public class SQLqueries {

    public String schoolTableTeacherName(String name){
        String query = "select teacher_name from school where teacher_name='"+name+"';";
        return query;
    }

    public String numberOfTeacherSchoolTable(){
        String query = "select count(teacher_name) from school ;" ;
        return query;
    }

    public String totalAmountPriceFactoryTable(){
        String query = "select sum(price) from factory ;";
        return query;
    }





}

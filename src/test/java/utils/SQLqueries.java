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


    public String totalNumberofFilmSakila(){
        // this is from sakila database
        String query = "select count(title) from film";
        return query;
    }

   public String teacherNameSchoolTable(String name){
        String query = "select teacher_name from school where teacher_name='"+name+"';";
        return query;
   }

   public String factoryTableIDName(int id){
        String query = "select material_name from factory where id="+id+";";
        return query;
   }

   public String listPositionDataPersonnelTable(){
        String query = "select position from personnel where position like '%er'";
        return query;
   }


}

package InsertNewData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertNewData {


    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "student";
        String password = "252646";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        try {
             connection = DriverManager.getConnection(dbUrl, user, password);
             statement = connection.createStatement();

            System.out.println("Inserting a new Employee!\n");

            int rowAffected = statement.executeUpdate(
                    "insert into employees" +
                            "(last_name, first_name, email, department, salary)"+
                            "values " +
                            "('Alamin', 'Md.', 'alamin5g@yahoo.com', 'Development', 200000)"
            );

            //Verify the inserting data by getting a list of employee
            resultSet = statement.executeQuery("select * from employees order by last_name");

            while (resultSet.next()){
                System.out.println(resultSet.getString("last_name")+ " " + resultSet.getString("first_name"));
            }

            System.out.println("\nTotal rows affected: " + rowAffected);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

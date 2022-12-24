package PrepareStatement;

import java.sql.*;

public class PrepareStatements {
    public static void main(String[] args){

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String dbUser = "student";
        String dbPass = "252646";

        try{
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            statement = connection.prepareStatement("select * from employees where salary > ? and department = ?");

            statement.setDouble(1, 30000);
            statement.setString(2, "HR");

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("last_name")+
                        " " + resultSet.getString("first_name") +
                        " " + resultSet.getString("email")+
                        " " + resultSet.getString("department")+
                        " " + resultSet.getDouble("salary"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

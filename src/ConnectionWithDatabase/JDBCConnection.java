package ConnectionWithDatabase;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        //1. Get a connection to databse;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student", "252646");

        System.out.println("Database Successfully Connected!");

        //2. Create a statement
        statement = connection.createStatement();

        //3. Execute SQL query
        resultSet = statement.executeQuery("select * from employees");

        //4. process the result set
        while(resultSet.next()){
            System.out.println(resultSet.getString("last_name")+ ", " + resultSet.getString("first_name"));
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

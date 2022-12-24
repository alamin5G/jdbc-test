package DeleteData;

import java.sql.*;

public class DeleteData {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String dbUrl = "jdbc:mysql://localhost:3306/demo";
        String user = "student";
        String password = "252646";

        try{
            connection = DriverManager.getConnection(dbUrl, user, password);
            statement = connection.createStatement();

            System.out.println("Before the Delete: ");
            displayEmployee(connection, "Alamin");

            System.out.println("\nAfter the delete: ");

            int affectedRow = statement.executeUpdate(
                    "delete from employees "+
                            "where last_name='Alamin' "
            );
            displayEmployee(connection, "Alamin");


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void displayEmployee(Connection connection, String lastName) {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;

        try {
            preparedStatement = connection.prepareStatement("select * from employees where last_name=?");
            preparedStatement.setString(1, lastName);

            resultSet = preparedStatement.executeQuery();

            // Process result set
            boolean found = false;

            while (resultSet.next()){
                String lastname = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String email = resultSet.getString("email");
                System.out.printf("Found employee: %s %s - %s", firstName, lastname, email);
                found = true;
            }

            if (!found){
                System.out.println("Employee Not found!");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

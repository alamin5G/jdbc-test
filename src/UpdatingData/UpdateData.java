package UpdatingData;

import java.sql.*;

public class UpdateData {
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
            resultSet = statement.executeQuery("select * from employees ");
            //show the data before update
            System.out.println("Before Update: ");
            displayEmployee(connection, "Alamin");


            //show the data after update
            System.out.println("\nAfter Update");
            int rowAffected = statement.executeUpdate(
                    "update employees " + "set email= 'qrst@xyz.com' "
                    + "where last_name='Alamin'"
            );

            displayEmployee(connection, "Alamin");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayEmployee(Connection myConn, String lastName) throws SQLException {
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // Prepare statement
            myStmt = myConn.prepareStatement("select * from employees where last_name=?");

            myStmt.setString(1, lastName);

            // Execute SQL query
            myRs = myStmt.executeQuery();

            // Process result set
            while (myRs.next()) {
                String theLastName = myRs.getString("last_name");
                String theFirstName = myRs.getString("first_name");
                String email = myRs.getString("email");

                System.out.printf("%s %s, %s\n", theFirstName, theLastName, email);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}

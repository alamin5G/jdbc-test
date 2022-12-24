import java.sql.*;

public class JdbcTest {

    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
        String user = "student";
        String password = "252646";

        try{
            //1. Get a connection to database;
            myConn = DriverManager.getConnection(dbUrl, user, password);

            //2. Create a statement
            myStmt = myConn.createStatement();

            //3. Execute SQL query


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

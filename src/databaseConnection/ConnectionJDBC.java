package databaseConnection;

import java.sql.*;

public class ConnectionJDBC {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    private static String user = "root";
    private static String password = "password";
    private static String url = "jdbc:mysql://localhost:3306/my_company";

    public static Connection connectJDBC() {

        try {
            LoadDriver.loadDriver(driver);
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Successful connection to the database");
            } catch (Exception exception) {
                System.out.println("Database connection failed. Class ConnectionJDBC");
                exception.printStackTrace();
            }
            System.out.println();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}

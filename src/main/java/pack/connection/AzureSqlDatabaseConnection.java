package pack.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AzureSqlDatabaseConnection { // Class name changed
    static Connection con;

    public static Connection getConnection() {
        try {
            // 1. Retrieve the connection string from the environment variable
            String connectionString = System.getenv("SQL_CONNECTION_STRING");

            // 2. Create connection (no need to load a driver explicitly for Azure SQL Database)
            try {
                con = DriverManager.getConnection(connectionString);
                System.out.println("Connected to Azure SQL Database");
            } catch (SQLException e) {
                System.err.println("Error connecting to Azure SQL Database: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Error getting connection string: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
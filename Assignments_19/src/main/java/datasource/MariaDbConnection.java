package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mariadb://localhost:3306/currencydb?user=appuserOCT23&password=salasana";
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.err.println("Connection failed.\n"+e.getMessage());
            }
        }
        return conn;
    }

    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            System.err.println("Connection termination failed.\n"+e.getMessage());
        }
    }
}

package datasource;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Connection conn = null;
    private static EntityManager em = null;
    private static EntityManagerFactory emf = null;

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

    public static EntityManager getEMInstance() {
        if (em == null) {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("CurrencyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}

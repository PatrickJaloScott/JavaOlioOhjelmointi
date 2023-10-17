package dao;

import datasource.MariaDbConnection;
import entity.CurrencyEntity;
import jakarta.persistence.EntityManager;

import java.sql.*;

public class CurrencyDao {
    private EntityManager em = MariaDbConnection.getEMInstance();
    private static Connection conn;
    public static String[] getCurrencyAbbreviations() {
        conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation FROM currency;";

        String[] abbreviations = new String[0];
        int count = 0;

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                count++;
            }
            abbreviations = new String[count];
            rs.beforeFirst();
            count = 0;
            while (rs.next()) {
                abbreviations[count] = rs.getString(1);
                count++;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return abbreviations;
    }

    public static double getCurrencyRate(String abbreviation) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT rate FROM currency WHERE abbreviation=?;");
            stmt.setString(1, abbreviation);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0.0;
    }
}

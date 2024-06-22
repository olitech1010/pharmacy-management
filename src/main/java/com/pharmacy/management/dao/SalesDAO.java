package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.Sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDAO {

    public void addSale(Sales sale) {
        String query = "INSERT INTO Sales (drugId, customerId, salesDate, quantity, amount) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sale.getDrugId());
            stmt.setInt(2, sale.getCustomerId());
            stmt.setDate(3, sale.getSalesDate()); // Assuming salesDate is a java.sql.Date object
            stmt.setInt(4, sale.getQuantity());
            stmt.setDouble(5, sale.getAmount());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Sales> getAllSales() {
        String query = "SELECT * FROM Sales";
        List<Sales> salesList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Sales sale = new Sales();
                sale.setSaleId(rs.getInt("saleId"));
                sale.setDrugId(rs.getInt("drugId"));
                sale.setCustomerId(rs.getInt("customerId"));
                sale.setSalesDate(rs.getDate("salesDate"));
                sale.setQuantity(rs.getInt("quantity"));
                sale.setAmount(rs.getDouble("amount"));
                
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salesList;
    }

    public void updateSale(Sales sale) {
        String query = "UPDATE Sales SET drugId = ?, customerId = ?, salesDate = ?, quantity = ?, amount = ? WHERE saleId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sale.getDrugId());
            stmt.setInt(2, sale.getCustomerId());
            stmt.setDate(3, sale.getSalesDate());
            stmt.setInt(4, sale.getQuantity());
            stmt.setDouble(5, sale.getAmount());
            stmt.setInt(6, sale.getSaleId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSale(int saleId) {
        String query = "DELETE FROM Sales WHERE saleId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, saleId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

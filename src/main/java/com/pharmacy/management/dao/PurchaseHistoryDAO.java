package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.PurchaseHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryDAO {

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        String query = "INSERT INTO PurchaseHistory (drugId, customerId, purchaseDate, quantity, totalAmount) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseHistory.getDrugId());
            stmt.setInt(2, purchaseHistory.getCustomerId());
            stmt.setTimestamp(3, purchaseHistory.getPurchaseDate());
            stmt.setInt(4, purchaseHistory.getQuantity());
            stmt.setDouble(5, purchaseHistory.getTotalAmount());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PurchaseHistory getPurchaseHistory(int purchaseId) {
        String query = "SELECT * FROM PurchaseHistory WHERE purchaseId = ?";
        PurchaseHistory purchaseHistory = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getInt("customerId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("quantity"),
                        rs.getDouble("totalAmount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistory;
    }

    public List<PurchaseHistory> getAllPurchaseHistory() {
        String query = "SELECT * FROM PurchaseHistory";
        List<PurchaseHistory> purchaseHistoryList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getInt("customerId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("quantity"),
                        rs.getDouble("totalAmount")
                );
                purchaseHistoryList.add(purchaseHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistoryList;
    }

    public void updatePurchaseHistory(PurchaseHistory purchaseHistory) {
        String query = "UPDATE PurchaseHistory SET drugId = ?, customerId = ?, purchaseDate = ?, quantity = ?, totalAmount = ? WHERE purchaseId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseHistory.getDrugId());
            stmt.setInt(2, purchaseHistory.getCustomerId());
            stmt.setTimestamp(3, purchaseHistory.getPurchaseDate());
            stmt.setInt(4, purchaseHistory.getQuantity());
            stmt.setDouble(5, purchaseHistory.getTotalAmount());
            stmt.setInt(6, purchaseHistory.getPurchaseId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePurchaseHistory(int purchaseId) {
        String query = "DELETE FROM PurchaseHistory WHERE purchaseId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

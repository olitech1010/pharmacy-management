package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.PurchaseHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryDAO {

    public void addPurchaseHistory(PurchaseHistory purchaseHistory) {
        String query = "INSERT INTO PurchaseHistory (purchaseId, drugId, purchaseDate, buyerId, quantityPurchased, totalAmount) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseHistory.getPurchaseId());
            stmt.setInt(2, purchaseHistory.getDrugId());
            stmt.setTimestamp(3, purchaseHistory.getPurchaseDate());
            stmt.setInt(4, purchaseHistory.getBuyerId());
            stmt.setInt(5, purchaseHistory.getQuantityPurchased());
            stmt.setDouble(6, purchaseHistory.getTotalAmount());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PurchaseHistory getPurchaseHistory(int purchaseId) {
        PurchaseHistory purchaseHistory = null;
        String query = "SELECT * FROM PurchaseHistory WHERE purchaseId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("buyerId"),
                        rs.getInt("quantityPurchased"),
                        rs.getDouble("totalAmount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistory;
    }

    public List<PurchaseHistory> getAllPurchaseHistory() {
        List<PurchaseHistory> purchaseHistories = new ArrayList<>();
        String query = "SELECT * FROM PurchaseHistory";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("buyerId"),
                        rs.getInt("quantityPurchased"),
                        rs.getDouble("totalAmount")
                );
                purchaseHistories.add(purchaseHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistories;
    }

    public void updatePurchaseHistory(PurchaseHistory purchaseHistory) {
        String query = "UPDATE PurchaseHistory SET drugId = ?, purchaseDate = ?, buyerId = ?, quantityPurchased = ?, totalAmount = ? " +
                "WHERE purchaseId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchaseHistory.getDrugId());
            stmt.setTimestamp(2, purchaseHistory.getPurchaseDate());
            stmt.setInt(3, purchaseHistory.getBuyerId());
            stmt.setInt(4, purchaseHistory.getQuantityPurchased());
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

    public List<PurchaseHistory> getPurchaseHistoryByDrug(int drugId) {
        List<PurchaseHistory> purchaseHistories = new ArrayList<>();
        String query = "SELECT * FROM PurchaseHistory WHERE drugId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, drugId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("buyerId"),
                        rs.getInt("quantityPurchased"),
                        rs.getDouble("totalAmount")
                );
                purchaseHistories.add(purchaseHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistories;
    }

    public List<PurchaseHistory> getPurchaseHistoryByBuyer(int buyerId) {
        List<PurchaseHistory> purchaseHistories = new ArrayList<>();
        String query = "SELECT * FROM PurchaseHistory WHERE buyerId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, buyerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("buyerId"),
                        rs.getInt("quantityPurchased"),
                        rs.getDouble("totalAmount")
                );
                purchaseHistories.add(purchaseHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistories;
    }

    public List<PurchaseHistory> getPurchaseHistoryByDate(String date) {
        List<PurchaseHistory> purchaseHistories = new ArrayList<>();
        String query = "SELECT * FROM PurchaseHistory WHERE DATE(purchaseDate) = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PurchaseHistory purchaseHistory = new PurchaseHistory(
                        rs.getInt("purchaseId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("purchaseDate"),
                        rs.getInt("buyerId"),
                        rs.getInt("quantityPurchased"),
                        rs.getDouble("totalAmount")
                );
                purchaseHistories.add(purchaseHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseHistories;
    }
}

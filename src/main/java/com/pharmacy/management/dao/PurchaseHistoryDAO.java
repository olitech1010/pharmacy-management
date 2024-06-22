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

    public void addPurchase(PurchaseHistory purchase) {
        String query = "INSERT INTO PurchaseHistory (drugId, supplierId, purchaseDate, quantity, amount) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchase.getDrugId());
            stmt.setInt(2, purchase.getSupplierId());
            stmt.setDate(3, purchase.getPurchaseDate());
            stmt.setInt(4, purchase.getQuantity());
            stmt.setDouble(5, purchase.getAmount());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PurchaseHistory> getAllPurchases() {
        String query = "SELECT * FROM PurchaseHistory";
        List<PurchaseHistory> purchaseList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PurchaseHistory purchase = new PurchaseHistory();
                purchase.setPurchaseId(rs.getInt("purchaseId"));
                purchase.setDrugId(rs.getInt("drugId"));
                purchase.setSupplierId(rs.getInt("supplierId"));
                purchase.setPurchaseDate(rs.getDate("purchaseDate"));
                purchase.setQuantity(rs.getInt("quantity"));
                purchase.setAmount(rs.getDouble("amount"));
                // Set other properties if needed
                purchaseList.add(purchase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return purchaseList;
    }

    public void updatePurchase(PurchaseHistory purchase) {
        String query = "UPDATE PurchaseHistory SET drugId = ?, supplierId = ?, purchaseDate = ?, quantity = ?, amount = ? WHERE purchaseId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, purchase.getDrugId());
            stmt.setInt(2, purchase.getSupplierId());
            stmt.setDate(3, purchase.getPurchaseDate());
            stmt.setInt(4, purchase.getQuantity());
            stmt.setDouble(5, purchase.getAmount());
            stmt.setInt(6, purchase.getPurchaseId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePurchase(int purchaseId) {
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

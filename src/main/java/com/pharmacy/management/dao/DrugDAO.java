package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDAO {

    public void addDrug(Drug drug) {
        String query = "INSERT INTO Drugs (drugId, drugName, quantity, price, supplierId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, drug.getDrugId());
            stmt.setString(2, drug.getDrugName());
            stmt.setInt(3, drug.getQuantity());
            stmt.setDouble(4, drug.getPrice());
            stmt.setInt(5, drug.getSupplierId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drug getDrug(int drugId) {
        Drug drug = null;
        String query = "SELECT * FROM Drugs WHERE drugId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, drugId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                drug = new Drug(
                        rs.getInt("drugId"),
                        rs.getString("drugName"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getInt("supplierId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drug;
    }

    public List<Drug> getAllDrugs() {
        List<Drug> drugs = new ArrayList<>();
        String query = "SELECT * FROM Drugs";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Drug drug = new Drug(
                        rs.getInt("drugId"),
                        rs.getString("drugName"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getInt("supplierId")
                );
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }

    public void updateDrug(Drug drug) {
        String query = "UPDATE Drugs SET drugName = ?, quantity = ?, price = ?, supplierId = ? WHERE drugId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, drug.getDrugName());
            stmt.setInt(2, drug.getQuantity());
            stmt.setDouble(3, drug.getPrice());
            stmt.setInt(4, drug.getSupplierId());
            stmt.setInt(5, drug.getDrugId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDrug(int drugId) {
        String query = "DELETE FROM Drugs WHERE drugId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, drugId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

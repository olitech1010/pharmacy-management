package com.pharmacy.management.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDAO {

    public void addDrug(Drug drug) {
        String query = "INSERT INTO Drugs (drugID, name) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, drug.getDrugID());
            stmt.setString(2, drug.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drug getDrug(String drugID) {
        String query = "SELECT * FROM Drugs WHERE drugID = ?";
        Drug drug = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, drugID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                drug = new Drug(rs.getString("drugID"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drug;
    }

    public List<Drug> getAllDrugs() {
        String query = "SELECT * FROM Drugs";
        List<Drug> drugs = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                drugs.add(new Drug(rs.getString("drugID"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drugs;
    }

    public void updateDrug(Drug drug) {
        String query = "UPDATE Drugs SET name = ? WHERE drugID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, drug.getName());
            stmt.setString(2, drug.getDrugID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDrug(String drugID) {
        String query = "DELETE FROM Drugs WHERE drugID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, drugID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

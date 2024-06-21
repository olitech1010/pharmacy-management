package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAO {

    // Method to add a supplier to the database
    public void addSupplier(Suppliers supplier) {
        String query = "INSERT INTO Suppliers (supplierId, supplierName, location) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, supplier.getSupplierId());
            stmt.setString(2, supplier.getSupplierName());
            stmt.setString(3, supplier.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a supplier from the database based on supplierId
    public Suppliers getSupplier(int supplierId) {
        String query = "SELECT * FROM Suppliers WHERE supplierId = ?";
        Suppliers supplier = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, supplierId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                supplier = new Suppliers(
                        rs.getInt("supplierId"),
                        rs.getString("supplierName"),
                        rs.getString("location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

    // Method to retrieve all suppliers from the database
    public List<Suppliers> getAllSuppliers() {
        String query = "SELECT * FROM Suppliers";
        List<Suppliers> suppliers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Suppliers supplier = new Suppliers(
                        rs.getInt("supplierId"),
                        rs.getString("supplierName"),
                        rs.getString("location")
                );
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }

    // Method to update a supplier in the database
    public void updateSupplier(Suppliers supplier) {
        String query = "UPDATE Suppliers SET supplierName = ?, location = ? WHERE supplierId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, supplier.getSupplierName());
            stmt.setString(2, supplier.getLocation());
            stmt.setInt(3, supplier.getSupplierId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a supplier from the database based on supplierId
    public void deleteSupplier(int supplierId) {
        String query = "DELETE FROM Suppliers WHERE supplierId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, supplierId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

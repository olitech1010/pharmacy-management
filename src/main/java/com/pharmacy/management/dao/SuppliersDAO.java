package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.Suppliers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuppliersDAO {

    // Method to add a supplier to the database
    public void addSupplier(Suppliers supplier) {
        // SQL query to insert a supplier into the Suppliers table
        String query = "INSERT INTO Suppliers (supplierId, supplierName, location) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, supplier.getSupplierId());
            stmt.setString(2, supplier.getSupplierName());
            stmt.setString(3, supplier.getLocation());

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add other methods as needed (e.g., getSupplier, updateSupplier, deleteSupplier)
}

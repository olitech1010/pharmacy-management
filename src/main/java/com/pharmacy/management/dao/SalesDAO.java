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

    // Method to add a sale to the database
    public void addSale(Sales sale) {
        String query = "INSERT INTO Sales (drugId, saleDate, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, sale.getDrugId());
            stmt.setTimestamp(2, sale.getSaleDate());
            stmt.setInt(3, sale.getQuantity());

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a sale from the database based on saleId
    public Sales getSale(int saleId) {
        String query = "SELECT * FROM Sales WHERE saleId = ?";
        Sales sale = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameter for the PreparedStatement
            stmt.setInt(1, saleId);

            // Execute the query and get the ResultSet
            ResultSet rs = stmt.executeQuery();

            // Check if a record was found
            if (rs.next()) {
                // Create a new Sales object from the ResultSet
                sale = new Sales(
                        rs.getInt("saleId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("saleDate"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the Sales object
        return sale;
    }

    // Method to retrieve all sales from the database
    public List<Sales> getAllSales() {
        String query = "SELECT * FROM Sales";
        List<Sales> salesList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Iterate through the ResultSet and create Sales objects
            while (rs.next()) {
                Sales sale = new Sales(
                        rs.getInt("saleId"),
                        rs.getInt("drugId"),
                        rs.getTimestamp("saleDate"),
                        rs.getInt("quantity")
                );
                salesList.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the list of Sales objects
        return salesList;
    }

    // Method to update a sale in the database
    public void updateSale(Sales sale) {
        String query = "UPDATE Sales SET drugId = ?, saleDate = ?, quantity = ? WHERE saleId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameters for the PreparedStatement
            stmt.setInt(1, sale.getDrugId());
            stmt.setTimestamp(2, sale.getSaleDate());
            stmt.setInt(3, sale.getQuantity());
            stmt.setInt(4, sale.getSaleId());

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a sale from the database based on saleId
    public void deleteSale(int saleId) {
        String query = "DELETE FROM Sales WHERE saleId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the parameter for the PreparedStatement
            stmt.setInt(1, saleId);

            // Execute the query
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

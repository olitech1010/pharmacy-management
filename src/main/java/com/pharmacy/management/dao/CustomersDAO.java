package com.pharmacy.management.dao;

import com.pharmacy.management.db.DatabaseConnection;
import com.pharmacy.management.model.Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO {

    // Method to add a customer to the database
    public void addCustomer(Customers customer) {
        String query = "INSERT INTO Customers (customerId, customerName, contact) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customer.getCustomerId());
            stmt.setString(2, customer.getCustomerName());
            stmt.setString(3, customer.getContact());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a customer from the database based on customerId
    public Customers getCustomer(int customerId) {
        String query = "SELECT * FROM Customers WHERE customerId = ?";
        Customers customer = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customers(
                        rs.getInt("customerId"),
                        rs.getString("customerName"),
                        rs.getString("contact")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    // Method to retrieve all customers from the database
    public List<Customers> getAllCustomers() {
        String query = "SELECT * FROM Customers";
        List<Customers> customers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customers customer = new Customers(
                        rs.getInt("customerId"),
                        rs.getString("customerName"),
                        rs.getString("contact")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // Method to update a customer in the database
    public void updateCustomer(Customers customer) {
        String query = "UPDATE Customers SET customerName = ?, contact = ? WHERE customerId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getContact());
            stmt.setInt(3, customer.getCustomerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a customer from the database based on customerId
    public void deleteCustomer(int customerId) {
        String query = "DELETE FROM Customers WHERE customerId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

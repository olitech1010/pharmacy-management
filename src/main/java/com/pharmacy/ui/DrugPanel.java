package com.pharmacy.ui;

import com.pharmacy.management.service.DrugService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugPanel extends JPanel {
    private DrugService drugService;

    private JTextField drugNameField;
    private JTextField drugQuantityField;
    private JTextField drugPriceField;

    public DrugPanel(DrugService drugService) {
        this.drugService = drugService;
        setLayout(new GridLayout(4, 2));

        // Initialize components
        JLabel nameLabel = new JLabel("Drug Name:");
        drugNameField = new JTextField();
        JLabel quantityLabel = new JLabel("Quantity:");
        drugQuantityField = new JTextField();
        JLabel priceLabel = new JLabel("Price:");
        drugPriceField = new JTextField();
        JButton addButton = new JButton("Add Drug");

        // Add components to the panel
        add(nameLabel);
        add(drugNameField);
        add(quantityLabel);
        add(drugQuantityField);
        add(priceLabel);
        add(drugPriceField);
        add(new JLabel()); // Empty cell
        add(addButton);

        // Add action listener to the button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });
    }

    private void addDrug() {
        String name = drugNameField.getText();
        String quantityText = drugQuantityField.getText();
        String priceText = drugPriceField.getText();

        // Validate inputs
        if (name.isEmpty() || quantityText.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity;
        double price;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add drug using the service
        drugService.addDrug(name, quantity, price);
        JOptionPane.showMessageDialog(this, "Drug added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Clear fields after successful addition
        drugNameField.setText("");
        drugQuantityField.setText("");
        drugPriceField.setText("");
    }
}

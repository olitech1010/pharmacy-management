package com.pharmacy.management.ui;

import com.pharmacy.management.service.DrugService;
import com.pharmacy.management.model.Drug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugPanel extends JPanel {
    private DrugService drugService;
    
    private JTextField drugIdField;
    private JTextField drugNameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextField supplierIdField;

    public DrugPanel(DrugService drugService) {
        this.drugService = drugService;

        setLayout(new GridLayout(6, 2));

        JLabel drugIdLabel = new JLabel("Drug ID:");
        drugIdField = new JTextField();

        JLabel drugNameLabel = new JLabel("Drug Name:");
        drugNameField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField();

        JLabel supplierIdLabel = new JLabel("Supplier ID:");
        supplierIdField = new JTextField();

        JButton addButton = new JButton("Add Drug");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });

        add(drugIdLabel);
        add(drugIdField);
        add(drugNameLabel);
        add(drugNameField);
        add(quantityLabel);
        add(quantityField);
        add(priceLabel);
        add(priceField);
        add(supplierIdLabel);
        add(supplierIdField);
        add(addButton);
    }

    private void addDrug() {
        int drugId = Integer.parseInt(drugIdField.getText());
        String drugName = drugNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        int supplierId = Integer.parseInt(supplierIdField.getText());

        Drug drug = new Drug(drugId, drugName, quantity, price, supplierId);
        drugService.addDrug(drug);

        JOptionPane.showMessageDialog(this, "Drug added successfully!");
    }
}

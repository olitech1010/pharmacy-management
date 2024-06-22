package com.pharmacy.ui;

import com.pharmacy.management.model.Sales;
import com.pharmacy.management.service.SalesService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class SalesPanel extends JPanel {
    private SalesService salesService;

    private JTextField drugIdField;
    private JTextField customerIdField;
    private JTextField salesDateField;
    private JTextField quantityField;
    private JTextField amountField;

    public SalesPanel(SalesService salesService) {
        this.salesService = salesService;

        setLayout(new GridLayout(6, 2));

        JLabel drugIdLabel = new JLabel("Drug ID:");
        drugIdField = new JTextField();

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField();

        JLabel salesDateLabel = new JLabel("Sales Date (YYYY-MM-DD):");
        salesDateField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JButton addButton = new JButton("Add Sale");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSale();
            }
        });

        add(drugIdLabel);
        add(drugIdField);
        add(customerIdLabel);
        add(customerIdField);
        add(salesDateLabel);
        add(salesDateField);
        add(quantityLabel);
        add(quantityField);
        add(amountLabel);
        add(amountField);
        add(addButton);
    }

    private void addSale() {
        int drugId = Integer.parseInt(drugIdField.getText());
        int customerId = Integer.parseInt(customerIdField.getText());
        Date salesDate = Date.valueOf(salesDateField.getText()); // Assuming correct date format
        int quantity = Integer.parseInt(quantityField.getText());
        double amount = Double.parseDouble(amountField.getText());

        Sales sale = new Sales();
        sale.setDrugId(drugId);
        sale.setCustomerId(customerId);
        sale.setSalesDate(salesDate);
        sale.setQuantity(quantity);
        sale.setAmount(amount);

        salesService.addSale(sale);

        JOptionPane.showMessageDialog(this, "Sale added successfully!");
    }
}

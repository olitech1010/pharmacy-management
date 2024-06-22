package com.pharmacy.ui;

import com.pharmacy.management.model.PurchaseHistory;
import com.pharmacy.management.service.PurchaseHistoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class PurchaseHistoryPanel extends JPanel {
    private PurchaseHistoryService purchaseHistoryService;

    private JTextField drugIdField;
    private JTextField supplierIdField;
    private JTextField purchaseDateField;
    private JTextField quantityField;
    private JTextField amountField;

    public PurchaseHistoryPanel(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;

        setLayout(new GridLayout(6, 2));

        JLabel drugIdLabel = new JLabel("Drug ID:");
        drugIdField = new JTextField();

        JLabel supplierIdLabel = new JLabel("Supplier ID:");
        supplierIdField = new JTextField();

        JLabel purchaseDateLabel = new JLabel("Purchase Date (YYYY-MM-DD):");
        purchaseDateField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField();

        JButton addButton = new JButton("Add Purchase");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPurchase();
            }
        });

        add(drugIdLabel);
        add(drugIdField);
        add(supplierIdLabel);
        add(supplierIdField);
        add(purchaseDateLabel);
        add(purchaseDateField);
        add(quantityLabel);
        add(quantityField);
        add(amountLabel);
        add(amountField);
        add(addButton);
    }

    private void addPurchase() {
        int drugId = Integer.parseInt(drugIdField.getText());
        int supplierId = Integer.parseInt(supplierIdField.getText());
        Date purchaseDate = Date.valueOf(purchaseDateField.getText()); // Assuming correct date format
        int quantity = Integer.parseInt(quantityField.getText());
        double amount = Double.parseDouble(amountField.getText());

        PurchaseHistory purchase = new PurchaseHistory();
        purchase.setDrugId(drugId);
        purchase.setSupplierId(supplierId);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setQuantity(quantity);
        purchase.setAmount(amount);

        purchaseHistoryService.addPurchase(purchase);

        JOptionPane.showMessageDialog(this, "Purchase added successfully!");
    }
}

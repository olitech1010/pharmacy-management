package com.pharmacy.management.ui;

import com.pharmacy.management.service.PurchaseHistoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PurchaseHistoryPanel extends JPanel {
    private PurchaseHistoryService purchaseHistoryService;
    
    private JTextField purchaseIdField;
    private JTextField drugIdField;
    private JTextField customerIdField;
    private JTextField quantityField;

    public PurchaseHistoryPanel(PurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;

        setLayout(new GridLayout(5, 2));

        JLabel purchaseIdLabel = new JLabel("Purchase ID:");
        purchaseIdField = new JTextField();

        JLabel drugIdLabel = new JLabel("Drug ID:");
        drugIdField = new JTextField();

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField();

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        JButton addButton = new JButton("Add Purchase");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPurchase();
            }
        });

        add(purchaseIdLabel);
        add(purchaseIdField);
        add(drugIdLabel);
        add(drugIdField);
        add(customerIdLabel);
        add(customerIdField);
        add(quantityLabel);
        add(quantityField);
        add(addButton);
    }

    private void addPurchase() {
        int purchaseId = Integer.parseInt(purchaseIdField.getText());
        int drugId = Integer.parseInt(drugIdField.getText());
        int customerId = Integer.parseInt(customerIdField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        purchaseHistoryService.addPurchaseHistory(purchaseId, drugId, customerId, quantity);

        JOptionPane.showMessageDialog(this, "Purchase added successfully!");
    }
}

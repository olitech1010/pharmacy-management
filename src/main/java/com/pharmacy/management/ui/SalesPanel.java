package com.pharmacy.management.ui;

import com.pharmacy.management.service.SalesService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesPanel extends JPanel {
    private SalesService salesService;
    
    private JTextField drugIdField;
    private JTextField customerIdField;

    public SalesPanel(SalesService salesService) {
        this.salesService = salesService;

        setLayout(new GridLayout(3, 2));

        JLabel drugIdLabel = new JLabel("Drug ID:");
        drugIdField = new JTextField();

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField();

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
        add(addButton);
    }

    private void addSale() {
        int drugId = Integer.parseInt(drugIdField.getText());
        int customerId = Integer.parseInt(customerIdField.getText());

        salesService.addSale(drugId, customerId);

        JOptionPane.showMessageDialog(this, "Sale added successfully!");
    }
}

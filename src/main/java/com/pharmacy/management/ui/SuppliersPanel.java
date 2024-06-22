package com.pharmacy.management.ui;

import com.pharmacy.management.model.Suppliers;
import com.pharmacy.management.service.SuppliersService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuppliersPanel extends JPanel {
    private SuppliersService supplierService;
    
    private JTextField supplierIdField;
    private JTextField supplierNameField;
    private JTextField contactField;

    public SuppliersPanel(SuppliersService supplierService) {
        this.supplierService = supplierService;

        setLayout(new GridLayout(4, 2));

        JLabel supplierIdLabel = new JLabel("Supplier ID:");
        supplierIdField = new JTextField();

        JLabel supplierNameLabel = new JLabel("Supplier Name:");
        supplierNameField = new JTextField();

        JLabel contactLabel = new JLabel("Contact:");
        contactField = new JTextField();

        JButton addButton = new JButton("Add Supplier");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSupplier();
            }
        });

        add(supplierIdLabel);
        add(supplierIdField);
        add(supplierNameLabel);
        add(supplierNameField);
        add(contactLabel);
        add(contactField);
        add(addButton);
    }

    private void addSupplier() {
        int supplierId = Integer.parseInt(supplierIdField.getText());
        String supplierName = supplierNameField.getText();
        String contact = contactField.getText();

        Suppliers supplier = new Suppliers(supplierId, supplierName, contact);
        supplierService.addSupplier(supplier);

        JOptionPane.showMessageDialog(this, "Supplier added successfully!");
    }
}

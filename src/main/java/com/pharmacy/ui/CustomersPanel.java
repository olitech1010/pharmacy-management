package com.pharmacy.ui;

import com.pharmacy.management.model.Customers;
import com.pharmacy.management.service.CustomersService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomersPanel extends JPanel {
    private CustomersService customerService;
    
    private JTextField customerIdField;
    private JTextField customerNameField;
    private JTextField contactField;

    public CustomersPanel(CustomersService customerService) {
        this.customerService = customerService;

        setLayout(new GridLayout(4, 2));

        JLabel customerIdLabel = new JLabel("Customer ID:");
        customerIdField = new JTextField();

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField();

        JLabel contactLabel = new JLabel("Contact:");
        contactField = new JTextField();

        JButton addButton = new JButton("Add Customer");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        add(customerIdLabel);
        add(customerIdField);
        add(customerNameLabel);
        add(customerNameField);
        add(contactLabel);
        add(contactField);
        add(new JLabel()); // empty cell for layout alignment
        add(addButton);
    }

    private void addCustomer() {
        String customerIdText = customerIdField.getText();
        String customerName = customerNameField.getText();
        String contact = contactField.getText();

        // Validate inputs
        if (customerIdText.isEmpty() || customerName.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int customerId;
        try {
            customerId = Integer.parseInt(customerIdText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid customer ID. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Customers customer = new Customers(customerId, customerName, contact);
        customerService.addCustomer(customer);

        JOptionPane.showMessageDialog(this, "Customer added successfully!");

        // Clear fields after successful addition
        customerIdField.setText("");
        customerNameField.setText("");
        contactField.setText("");
    }
}

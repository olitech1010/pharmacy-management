package com.pharmacy.ui;

import com.pharmacy.management.model.Customers;
import com.pharmacy.management.service.CustomersService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.JFrame;
import javax.swing.JLabel;


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
        add(addButton);
    }

    private void addCustomer() {
        int customerId = Integer.parseInt(customerIdField.getText());
        String customerName = customerNameField.getText();
        String contact = contactField.getText();

        Customers customer = new Customers(customerId, customerName, contact);
        customerService.addCustomer(customer);

        JOptionPane.showMessageDialog(this, "Customer added successfully!");
    }
}

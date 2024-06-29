package com.pharmacy.management;

import com.pharmacy.management.service.DrugService;
import com.pharmacy.management.service.CustomersService;
import com.pharmacy.management.service.SalesService;
import com.pharmacy.ui.CustomersPanel;
import com.pharmacy.ui.DrugPanel;
import com.pharmacy.ui.SalesPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacyApp extends JFrame {

    private JPanel contentPanel;
    private DrugService drugService;
    private CustomersService customersService;
    private SalesService salesService;

    public PharmacyApp() {
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize services
        drugService = new DrugService(); // Replace with actual service initialization
        customersService = new CustomersService(); // Replace with actual service initialization
        salesService = new SalesService(); // Replace with actual service initialization

        // Create the main content panel with CardLayout
        contentPanel = new JPanel(new CardLayout());
        setContentPane(contentPanel);

        // Create panels for different views
        JPanel drugPanel = new DrugPanel(drugService);
        JPanel customersPanel = new CustomersPanel(customersService);
        JPanel salesPanel = new SalesPanel(salesService);

        // Add panels to the content panel with unique names
        contentPanel.add(drugPanel, "DrugPanel");
        contentPanel.add(customersPanel, "CustomersPanel");
        contentPanel.add(salesPanel, "SalesPanel");

        // Create buttons for navigation
        JButton drugButton = new JButton("Drugs");
        JButton customersButton = new JButton("Customers");
        JButton salesButton = new JButton("Sales");

        // Add action listeners to the buttons for switching panels
        drugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "DrugPanel");
            }
        });

        customersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "CustomersPanel");
            }
        });

        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "SalesPanel");
            }
        });

        // Create a navigation panel and add buttons to it
        JPanel navigationPanel = new JPanel(new GridLayout(1, 3));
        navigationPanel.add(drugButton);
        navigationPanel.add(customersButton);
        navigationPanel.add(salesButton);

        // Add the navigation panel to the main content pane
        add(navigationPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PharmacyApp app = new PharmacyApp();
                app.setVisible(true);
            }
        });
    }
}

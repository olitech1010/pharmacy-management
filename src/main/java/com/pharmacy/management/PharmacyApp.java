package com.pharmacy.management;

import com.pharmacy.management.service.*;
import com.pharmacy.ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacyApp extends JFrame {

    private DrugService drugService;
    private SuppliersService supplierService;
    private CustomersService customerService;
    private SalesService salesService;
    private PurchaseHistoryService purchaseHistoryService;

    public PharmacyApp() {
        // Initialize the services
        drugService = new DrugService();
        supplierService = new SuppliersService();
        customerService = new CustomersService();
        salesService = new SalesService();
        purchaseHistoryService = new PurchaseHistoryService();

        // Set up the main window
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel to hold content
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create a navigation panel
        JPanel navigationPanel = createNavigationPanel();
        mainPanel.add(navigationPanel, BorderLayout.NORTH);

        // Create a content panel to display different views
        JPanel contentPanel = new JPanel(new CardLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Add different panels for drug, supplier, customer, sales, and purchase history
        contentPanel.add(new DrugPanel(drugService), "DrugPanel");
        contentPanel.add(new SuppliersPanel(supplierService), "SupplierPanel");
        contentPanel.add(new CustomersPanel(customerService), "CustomerPanel");
        contentPanel.add(new SalesPanel(salesService), "SalesPanel");
        contentPanel.add(new PurchaseHistoryPanel(purchaseHistoryService), "PurchaseHistoryPanel");
    }

    // Helper method to create the navigation panel with buttons
    private JPanel createNavigationPanel() {
        JPanel navigationPanel = new JPanel(new GridLayout(1, 5));

        JButton drugButton = createNavigationButton("Drugs", "DrugPanel");
        JButton supplierButton = createNavigationButton("Suppliers", "SupplierPanel");
        JButton customerButton = createNavigationButton("Customers", "CustomerPanel");
        JButton salesButton = createNavigationButton("Sales", "SalesPanel");
        JButton purchaseHistoryButton = createNavigationButton("Purchase History", "PurchaseHistoryPanel");

        navigationPanel.add(drugButton);
        navigationPanel.add(supplierButton);
        navigationPanel.add(customerButton);
        navigationPanel.add(salesButton);
        navigationPanel.add(purchaseHistoryButton);

        return navigationPanel;
    }

    // Helper method to create navigation buttons
    private JButton createNavigationButton(String buttonText, String panelName) {
        JButton button = new JButton(buttonText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), panelName);
            }
        });
        return button;
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PharmacyApp app = new PharmacyApp();
                app.setVisible(true);
            }
        });
    }
}

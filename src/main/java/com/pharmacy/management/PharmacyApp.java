package com.pharmacy.management;

import com.pharmacy.management.service.*;
import com.pharmacy.management.ui.*;

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
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drugService = new DrugService();
        supplierService = new SuppliersService();
        customerService = new CustomersService();
        salesService = new SalesService();
        purchaseHistoryService = new PurchaseHistoryService();

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create a panel for content display
        JPanel contentPanel = new JPanel(new CardLayout());
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Create and add the drug panel
        DrugPanel drugPanel = new DrugPanel(drugService);
        contentPanel.add(drugPanel, "DrugPanel");

        // Create and add the supplier panel
        SuppliersPanel supplierPanel = new SuppliersPanel(supplierService);
        contentPanel.add(supplierPanel, "SupplierPanel");

        // Create and add the customer panel
        CustomersPanel customerPanel = new CustomersPanel(customerService);
        contentPanel.add(customerPanel, "CustomerPanel");

        // Create and add the sales panel
        SalesPanel salesPanel = new SalesPanel(salesService);
        contentPanel.add(salesPanel, "SalesPanel");

        // Create and add the purchase history panel
        PurchaseHistoryPanel purchaseHistoryPanel = new PurchaseHistoryPanel(purchaseHistoryService);
        contentPanel.add(purchaseHistoryPanel, "PurchaseHistoryPanel");

        // Create a navigation panel
        JPanel navigationPanel = new JPanel(new GridLayout(1, 5));
        mainPanel.add(navigationPanel, BorderLayout.NORTH);

        JButton drugButton = new JButton("Drugs");
        drugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "DrugPanel");
            }
        });
        navigationPanel.add(drugButton);

        JButton supplierButton = new JButton("Suppliers");
        supplierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "SupplierPanel");
            }
        });
        navigationPanel.add(supplierButton);

        JButton customerButton = new JButton("Customers");
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "CustomerPanel");
            }
        });
        navigationPanel.add(customerButton);

        JButton salesButton = new JButton("Sales");
        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "SalesPanel");
            }
        });
        navigationPanel.add(salesButton);

        JButton purchaseHistoryButton = new JButton("Purchase History");
        purchaseHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentPanel.getLayout();
                cl.show(contentPanel, "PurchaseHistoryPanel");
            }
        });
        navigationPanel.add(purchaseHistoryButton);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PharmacyApp app = new PharmacyApp();
                app.setVisible(true);
            }
        });
    }
}

package com.pharmacy.management;

import com.pharmacy.management.service.DrugService;
import com.pharmacy.management.service.UserService;
import com.pharmacy.ui.DrugPanel;
import com.pharmacy.ui.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class PharmacyApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DrugService drugService;
    private UserService userService;

    public PharmacyApp() {
        drugService = new DrugService();
        userService = new UserService();

        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize panels
        LoginPanel loginPanel = new LoginPanel(userService, cardLayout, mainPanel);
        DrugPanel drugPanel = new DrugPanel(drugService);

        // Add panels to main panel with card layout
        mainPanel.add(loginPanel, "login");
        mainPanel.add(drugPanel, "drug");

        // Add main panel to frame
        add(mainPanel);

        // Show the login panel initially
        cardLayout.show(mainPanel, "login");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PharmacyApp().setVisible(true);
            }
        });
    }
}

package com.pharmacy.management;

import com.pharmacy.management.service.DrugService;
import com.pharmacy.management.ui.DrugPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class PharmacyApp extends JFrame {

    private DrugService drugService;

    public PharmacyApp() {
        setTitle("Pharmacy Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drugService = new DrugService();

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create and add the drug panel
        DrugPanel drugPanel = new DrugPanel(drugService);
        mainPanel.add(drugPanel, BorderLayout.CENTER);
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

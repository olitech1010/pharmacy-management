package com.pharmacy.management.service;

import com.pharmacy.management.dao.PurchaseHistoryDAO;
import com.pharmacy.management.model.PurchaseHistory;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseHistoryService {

    private PurchaseHistoryDAO purchaseHistoryDAO;

    public PurchaseHistoryService() {
        this.purchaseHistoryDAO = new PurchaseHistoryDAO();
    }

    // Method to add a new purchase history record
    public void addPurchaseHistory(int drugId, int customerId, Timestamp purchaseDate, int quantity, double totalAmount) {
        PurchaseHistory purchaseHistory = new PurchaseHistory(0, drugId, customerId, purchaseDate, quantity, totalAmount);
        purchaseHistoryDAO.addPurchaseHistory(purchaseHistory);
    }

    // Method to get a purchase history record by its ID
    public PurchaseHistory getPurchaseHistory(int purchaseId) {
        return purchaseHistoryDAO.getPurchaseHistory(purchaseId);
    }

    // Method to get all purchase history records
    public List<PurchaseHistory> getAllPurchaseHistory() {
        return purchaseHistoryDAO.getAllPurchaseHistory();
    }

    // Method to update an existing purchase history record
    public void updatePurchaseHistory(int purchaseId, int drugId, int customerId, Timestamp purchaseDate, int quantity, double totalAmount) {
        PurchaseHistory purchaseHistory = new PurchaseHistory(purchaseId, drugId, customerId, purchaseDate, quantity, totalAmount);
        purchaseHistoryDAO.updatePurchaseHistory(purchaseHistory);
    }

    // Method to delete a purchase history record by its ID
    public void deletePurchaseHistory(int purchaseId) {
        purchaseHistoryDAO.deletePurchaseHistory(purchaseId);
    }
}

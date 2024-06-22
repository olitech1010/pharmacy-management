package com.pharmacy.management.service;

import com.pharmacy.management.dao.PurchaseHistoryDAO;
import com.pharmacy.management.model.PurchaseHistory;

import java.util.List;

public class PurchaseHistoryService {
    private PurchaseHistoryDAO purchaseHistoryDAO;

    public PurchaseHistoryService() {
        this.purchaseHistoryDAO = new PurchaseHistoryDAO();
    }

    public void addPurchase(PurchaseHistory purchase) {
        purchaseHistoryDAO.addPurchase(purchase);
    }

    public List<PurchaseHistory> getAllPurchases() {
        return purchaseHistoryDAO.getAllPurchases();
    }

    public void updatePurchase(PurchaseHistory purchase) {
        purchaseHistoryDAO.updatePurchase(purchase);
    }

    public void deletePurchase(int purchaseId) {
        purchaseHistoryDAO.deletePurchase(purchaseId);
    }
}

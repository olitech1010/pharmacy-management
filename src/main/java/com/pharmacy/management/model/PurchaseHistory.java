package com.pharmacy.management.model;

import java.sql.Timestamp;

public class PurchaseHistory {
    private int purchaseId;
    private int drugId;
    private Timestamp purchaseDate;
    private int buyerId;
    private int quantityPurchased;
    private double totalAmount;

    // Constructors
    public PurchaseHistory() {
    }

    public PurchaseHistory(int purchaseId, int drugId, Timestamp purchaseDate, int buyerId,
                           int quantityPurchased, double totalAmount) {
        this.purchaseId = purchaseId;
        this.drugId = drugId;
        this.purchaseDate = purchaseDate;
        this.buyerId = buyerId;
        this.quantityPurchased = quantityPurchased;
        this.totalAmount = totalAmount;
    }

    // Getters and setters

    public int getPurchaseId() {
        return purchaseId;
    }
    
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }
    
    public int getDrugId() {
        return drugId;
    }
    
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
    
    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public int getBuyerId() {
        return buyerId;
    }
    
    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }
    
    public int getQuantityPurchased() {
        return quantityPurchased;
    }
    
    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
}

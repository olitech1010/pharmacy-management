package com.pharmacy.management.model;

import java.sql.Date;

public class PurchaseHistory {
    private int purchaseId;
    private int drugId;
    private int supplierId;
    private Date purchaseDate;
    private int quantity;
    private double amount;

    // Getters and Setters
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
    
    public int getSupplierId() {
        return supplierId;
    }
    
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    
    public Date getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

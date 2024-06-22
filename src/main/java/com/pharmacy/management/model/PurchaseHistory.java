package com.pharmacy.management.model;

import java.sql.Timestamp;

public class PurchaseHistory {
    private int purchaseId;
    private int drugId;
    private int customerId;
    private Timestamp purchaseDate;
    private int quantity;
    private double totalAmount;

    // Constructor
    public PurchaseHistory(int purchaseId, int drugId, int customerId, Timestamp purchaseDate, int quantity, double totalAmount) {
        this.purchaseId = purchaseId;
        this.drugId = drugId;
        this.customerId = customerId;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // toString method for easy debugging and logging
    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "purchaseId=" + purchaseId +
                ", drugId=" + drugId +
                ", customerId=" + customerId +
                ", purchaseDate=" + purchaseDate +
                ", quantity=" + quantity +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

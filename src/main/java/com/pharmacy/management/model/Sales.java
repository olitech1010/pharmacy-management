package com.pharmacy.management.model;

import java.sql.Timestamp;

public class Sales {
    private int saleId;
    private int drugId;
    private Timestamp saleDate;
    private int quantitySold;
    private double totalAmount;

    // Constructors
    public Sales() {
    }

    public Sales(int saleId, int drugId, Timestamp saleDate, int quantitySold, double totalAmount) {
        this.saleId = saleId;
        this.drugId = drugId;
        this.saleDate = saleDate;
        this.quantitySold = quantitySold;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public int getSaleId() {
        return saleId;
    }
    
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
    
    public int getDrugId() {
        return drugId;
    }
    
    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }
    
    public Timestamp getSaleDate() {
        return saleDate;
    }
    
    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }
    
    public int getQuantitySold() {
        return quantitySold;
    }
    
    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

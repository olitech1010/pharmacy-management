package com.pharmacy.management.model;

import java.sql.Date;

public class Sales {
    private int saleId;
    private int drugId;
    private int customerId;
    private Date salesDate;
    private int quantity;
    private double amount;

    // Getters and Setters
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
    
    public int getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public Date getSalesDate() {
        return salesDate;
    }
    
    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
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

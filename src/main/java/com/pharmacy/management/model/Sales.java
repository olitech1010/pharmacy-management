package com.pharmacy.management.model;

import java.sql.Timestamp;

public class Sales {
    private int saleId;
    private int drugId;
    private Timestamp saleDate;
    private int quantity;

    // Constructor
    public Sales(int saleId, int drugId, Timestamp saleDate, int quantity) {
        this.saleId = saleId;
        this.drugId = drugId;
        this.saleDate = saleDate;
        this.quantity = quantity;
    }

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

    public Timestamp getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Timestamp saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method for easy debugging and logging
    @Override
    public String toString() {
        return "Sales{" +
                "saleId=" + saleId +
                ", drugId=" + drugId +
                ", saleDate=" + saleDate +
                ", quantity=" + quantity +
                '}';
    }
}

package com.pharmacy.management.model;

public class Drug {
    private int drugId;
    private String drugName;
    private int quantity;
    private double price;
    private int supplierId;

    // Constructors
    public Drug() {
    }

    public Drug(int drugId, String drugName, int quantity, double price, int supplierId) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
    }

    // Getters and setters
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", supplierId=" + supplierId +
                '}';
    }
}

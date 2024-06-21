package com.pharmacy.management.model;

public class Suppliers {
    private int supplierId;
    private String supplierName;
    private String location;

    public Suppliers(int supplierId, String supplierName, String location) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.location = location;
    }

    // Getters and setters
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

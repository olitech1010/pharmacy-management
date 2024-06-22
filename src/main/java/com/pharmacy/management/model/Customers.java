package com.pharmacy.management.model;

public class Customers {
    private int customerId;
    private String customerName;
    private String contact;

    public Customers(int customerId, String customerName, String contact) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contact = contact;
    }

    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

package com.pharmacy.management.model;

public class Customers {
    private int customerId;
    private String customerName;
    private String address;
    private String phone;

    // Constructors
    public Customers() {
    }

    public Customers(int customerId, String customerName, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
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
   
   public String getAddress() {
       return address;
   }
   
   public void setAddress(String address) {
       this.address = address;
   }
   
   public String getPhone() {
       return phone;
   }
   
   public void setPhone(String phone) {
       this.phone = phone;
   }
}

package com.pharmacy.management.service;

import com.pharmacy.management.dao.CustomersDAO;
import com.pharmacy.management.model.Customers;

import java.util.List;

public class CustomersService {
    private CustomersDAO customersDAO;

    public CustomersService() {
        this.customersDAO = new CustomersDAO();
    }

    public void addCustomer(Customers customer) {
        customersDAO.addCustomer(customer);
    }

    public Customers getCustomer(int customerId) {
        return customersDAO.getCustomer(customerId);
    }

    public List<Customers> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    public void updateCustomer(Customers customer) {
        customersDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        customersDAO.deleteCustomer(customerId);
    }
}

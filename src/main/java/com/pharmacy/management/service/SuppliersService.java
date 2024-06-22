package com.pharmacy.management.service;

import com.pharmacy.management.dao.SuppliersDAO;
import com.pharmacy.management.model.Suppliers;

import java.util.List;

public class SuppliersService {
    private SuppliersDAO suppliersDAO;

    public SuppliersService() {
        this.suppliersDAO = new SuppliersDAO();
    }

    public void addSupplier(Suppliers supplier) {
        suppliersDAO.addSupplier(supplier);
    }

    public Suppliers getSupplier(int supplierId) {
        return suppliersDAO.getSupplier(supplierId);
    }

    public List<Suppliers> getAllSuppliers() {
        return suppliersDAO.getAllSuppliers();
    }

    public void updateSupplier(Suppliers supplier) {
        suppliersDAO.updateSupplier(supplier);
    }

    public void deleteSupplier(int supplierId) {
        suppliersDAO.deleteSupplier(supplierId);
    }
}

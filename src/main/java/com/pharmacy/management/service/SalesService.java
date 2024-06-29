package com.pharmacy.management.service;

import com.pharmacy.management.dao.SalesDAO;
import com.pharmacy.management.model.Sales;

import java.util.List;

public class SalesService {
    private SalesDAO salesDAO;

    public SalesService() {
        this.salesDAO = new SalesDAO();
    }

    public void addSale(int drugId, int customerId, java.sql.Date salesDate, int quantity, double amount) {
        Sales sale = new Sales();
        sale.setDrugId(drugId);
        sale.setCustomerId(customerId);
        sale.setSalesDate(salesDate);
        sale.setQuantity(quantity);
        sale.setAmount(amount);

        salesDAO.addSale(sale);
    }

    public List<Sales> getAllSales() {
        return salesDAO.getAllSales();
    }

    public void updateSale(Sales sale) {
        salesDAO.updateSale(sale);
    }

    public void deleteSale(int saleId) {
        salesDAO.deleteSale(saleId);
    }
}


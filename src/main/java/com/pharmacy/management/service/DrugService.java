package com.pharmacy.management.service;

import com.pharmacy.management.dao.DrugDAO;
import com.pharmacy.management.model.Drug;

import java.util.List;

public class DrugService {
    private DrugDAO drugDAO;

    public DrugService() {
        this.drugDAO = new DrugDAO();
    }

    public void addDrug(Drug drug) {
        drugDAO.addDrug(drug);
    }

    public Drug getDrug(int drugId) {
        return drugDAO.getDrug(drugId);
    }

    public List<Drug> getAllDrugs() {
        return drugDAO.getAllDrugs();
    }

    public void updateDrug(Drug drug) {
        drugDAO.updateDrug(drug);
    }

    public void deleteDrug(int drugId) {
        drugDAO.deleteDrug(drugId);
    }
}

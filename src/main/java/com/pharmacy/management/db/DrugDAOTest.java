package com.pharmacy.management.db;

public class DrugDAOTest {

    public static void main(String[] args) {
        DrugDAO drugDAO = new DrugDAO();

        // Create and add a new drug
        Drug drug1 = new Drug("D001", "Aspirin");
        drugDAO.addDrug(drug1);

        // Read a drug
        Drug retrievedDrug = drugDAO.getDrug("D001");
        System.out.println("Retrieved Drug: " + retrievedDrug.getName());

        // Update the drug
        retrievedDrug.setName("Aspirin 500mg");
        drugDAO.updateDrug(retrievedDrug);

        // Read all drugs
        System.out.println("All Drugs:");
        for (Drug drug : drugDAO.getAllDrugs()) {
            System.out.println(drug.getName());
        }

        // Delete the drug
        drugDAO.deleteDrug("D001");
    }
}

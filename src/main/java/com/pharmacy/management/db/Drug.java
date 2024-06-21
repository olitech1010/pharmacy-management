package com.pharmacy.management.db;

public class Drug {
    private String drugID;
    private String name;

    public Drug(String drugID, String name) {
        this.drugID = drugID;
        this.name = name;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

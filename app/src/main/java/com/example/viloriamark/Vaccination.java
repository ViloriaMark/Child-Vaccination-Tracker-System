package com.example.viloriamark;

public class Vaccination {

    private final String childName;
    private final String vaccinationDate;

    public Vaccination(String childName, String vaccinationDate) {
        this.childName = childName;
        this.vaccinationDate = vaccinationDate;
    }

    public String getChildName() {
        return childName;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }
}


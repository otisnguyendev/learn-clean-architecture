package com.lab.entity;

public class CustomerForeigner extends Customer {
    private String nationality;

    public CustomerForeigner(String customerID, String fullName, String billDate, int quantity, double unitPrice, String nationality) {
        super(customerID, fullName, billDate, quantity, unitPrice);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

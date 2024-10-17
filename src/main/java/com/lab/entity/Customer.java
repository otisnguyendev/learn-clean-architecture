package com.lab.entity;

import java.util.Date;

public class Customer {
    protected String customerID;
    protected String fullName;
    protected String billDate;
    protected int quantity;
    protected double unitPrice;

    public Customer() {
    }

    public Customer(String customerID, String fullName, String billDate, int quantity, double unitPrice) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.billDate = billDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

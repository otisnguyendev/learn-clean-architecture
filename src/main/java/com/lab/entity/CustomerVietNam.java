package com.lab.entity;

public class CustomerVietNam extends Customer {
    private String customerType;
    private int consumptionLimit;

    public CustomerVietNam(String customerID, String fullName, String billDate, int quantity, double unitPrice, String customerType, int consumptionLimit) {
        super(customerID, fullName, billDate, quantity, unitPrice);
        this.customerType = customerType;
        this.consumptionLimit = consumptionLimit;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getConsumptionLimit() {
        return consumptionLimit;
    }

    public void setConsumptionLimit(int consumptionLimit) {
        this.consumptionLimit = consumptionLimit;
    }

}

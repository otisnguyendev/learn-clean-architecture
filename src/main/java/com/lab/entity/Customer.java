package com.lab.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Customer {
    protected String customerID;
    protected String fullName;
    protected LocalDate invoiceDate;
    protected int quantity;
    protected double unitPrice;

    public abstract double calculateTotal();
}

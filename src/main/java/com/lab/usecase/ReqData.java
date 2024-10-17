package com.lab.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReqData {
    private String customerId;
    private String name;
    private String nationality;
    private String customerType;
    private LocalDate invoiceDate;
    private int quantity;
    private double unitPrice;
    private double limit;
}

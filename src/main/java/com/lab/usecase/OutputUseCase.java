package com.lab.usecase;

import com.lab.entity.Customer;

import java.util.List;

public interface OutputUseCase {
    long[] calculateCustomerCounts();
    double calculateAverageTotalForeigner();
    List<Customer> getInvoicesByMonth(int month, int year);
}

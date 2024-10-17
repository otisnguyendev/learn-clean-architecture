package com.lab.usecase;

import com.lab.entity.Customer;

import java.util.List;

public interface DatabaseUseCase {
    void addInvoice(Customer customer);
    void removeInvoice(String customerId);
    void updateInvoice(Customer customer);
    List<Customer> getAllInvoices();
    List<Customer> getInvoicesByMonth(int month, int year);
}

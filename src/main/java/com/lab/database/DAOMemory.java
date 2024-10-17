package com.lab.database;

import com.lab.entity.Customer;
import com.lab.usecase.DatabaseUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAOMemory implements DatabaseUseCase {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void addInvoice(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void removeInvoice(String customerId) {
        customers.removeIf(c -> c.getCustomerID().equals(customerId));
    }

    @Override
    public void updateInvoice(Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerID().equals(customer.getCustomerID())) {
                customers.set(i, customer);
                break;
            }
        }
    }

    @Override
    public List<Customer> getAllInvoices() {
        return List.of();
    }

    @Override
    public List<Customer> getInvoicesByMonth(int month, int year) {
        return customers.stream()
                .filter(c -> c.getInvoiceDate().getMonthValue() == month && c.getInvoiceDate().getYear() == year)
                .collect(Collectors.toList());
    }
}

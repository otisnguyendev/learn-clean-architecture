package com.lab.usecase;

import com.lab.entity.Customer;
import com.lab.entity.CustomerForeigner;
import com.lab.entity.CustomerVietNam;

import java.util.List;
import java.util.stream.Collectors;

public class UseCase implements InputUseCase, OutputUseCase {
    private DatabaseUseCase databaseUseCase;

    public UseCase(DatabaseUseCase databaseUseCase) {
        this.databaseUseCase = databaseUseCase;
    }

    @Override
    public void addInvoice(ReqData data) {
        if (data.getNationality() == null) {
            CustomerVietNam customer = new CustomerVietNam();
            customer.setCustomerID(data.getCustomerId());
            customer.setFullName(data.getName());
            customer.setInvoiceDate(data.getInvoiceDate());
            customer.setQuantity(data.getQuantity());
            customer.setUnitPrice(data.getUnitPrice());
            customer.setCustomerType(data.getCustomerType());
            customer.setLimit(data.getLimit());
            databaseUseCase.addInvoice(customer);
        } else {
            CustomerForeigner customer = new CustomerForeigner();
            customer.setCustomerID(data.getCustomerId());
            customer.setFullName(data.getName());
            customer.setInvoiceDate(data.getInvoiceDate());
            customer.setQuantity(data.getQuantity());
            customer.setUnitPrice(data.getUnitPrice());
            customer.setNationality(data.getNationality());
            databaseUseCase.addInvoice(customer);
        }
    }

    @Override
    public void updateInvoice(ReqData data) {
        if (data.getNationality() == null) {
            CustomerVietNam customer = new CustomerVietNam();
            customer.setCustomerID(data.getCustomerId());
            customer.setFullName(data.getName());
            customer.setInvoiceDate(data.getInvoiceDate());
            customer.setQuantity(data.getQuantity());
            customer.setUnitPrice(data.getUnitPrice());
            customer.setCustomerType(data.getCustomerType());
            customer.setLimit(data.getLimit());

            databaseUseCase.updateInvoice(customer);
        } else {
            CustomerForeigner customer = new CustomerForeigner();
            customer.setCustomerID(data.getCustomerId());
            customer.setFullName(data.getName());
            customer.setInvoiceDate(data.getInvoiceDate());
            customer.setQuantity(data.getQuantity());
            customer.setUnitPrice(data.getUnitPrice());
            customer.setNationality(data.getNationality());

            databaseUseCase.updateInvoice(customer);
        }
    }

    @Override
    public void removeInvoice(String customerId) {
        databaseUseCase.removeInvoice(customerId);
    }

    @Override
    public long[] calculateCustomerCounts() {
        long vietnamCount = databaseUseCase.getAllInvoices().stream()
                .filter(c -> c instanceof CustomerVietNam)
                .count();

        long foreignerCount = databaseUseCase.getAllInvoices().stream()
                .filter(c -> c instanceof CustomerForeigner)
                .count();

        return new long[]{vietnamCount, foreignerCount};
    }

    @Override
    public double calculateAverageTotalForeigner() {
        List<Customer> foreignCustomers = databaseUseCase.getAllInvoices().stream()
                .filter(c -> c instanceof CustomerForeigner)
                .collect(Collectors.toList());

        return foreignCustomers.stream()
                .mapToDouble(Customer::calculateTotal)
                .average()
                .orElse(0);
    }

    @Override
    public List<Customer> getInvoicesByMonth(int month, int year) {
        return databaseUseCase.getInvoicesByMonth(month, year);
    }

}

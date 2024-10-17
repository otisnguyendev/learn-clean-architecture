package com.lab.usecase;

import com.lab.entity.Customer;

import java.util.List;

public interface DatabaseUseCase {
    List<Customer> getAllCustomers();
}

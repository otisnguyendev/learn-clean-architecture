package com.lab.database;

import com.lab.entity.Customer;
import com.lab.usecase.DatabaseUseCase;

import java.util.ArrayList;
import java.util.List;

public class DAOMemory implements DatabaseUseCase {
    List<Customer> list = new ArrayList<Customer>();
    @Override
    public List<Customer> getAllCustomers() {
        return this.list;
    }
}

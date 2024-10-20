package com.lab.ui;

import com.lab.entity.Customer;
import com.lab.usecase.OutputUseCase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Presenter implements OutputUseCase {
    private OutputUseCase outputUseCase;

    @Override
    public long[] calculateCustomerCounts() {
        return outputUseCase.calculateCustomerCounts();
    }

    @Override
    public double calculateAverageTotalForeigner() {
        return outputUseCase.calculateAverageTotalForeigner();
    }

    @Override
    public List<Customer> getInvoicesByMonth(int month, int year) {
        return outputUseCase.getInvoicesByMonth(month, year);
    }
}

package com.lab.ui;

import com.lab.usecase.InputUseCase;
import com.lab.usecase.ReqData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Controller implements InputUseCase {
    private InputUseCase inputUseCase;

    @Override
    public void addInvoice(ReqData data) {
        inputUseCase.addInvoice(data);
    }

    @Override
    public void removeInvoice(String customerId) {
        inputUseCase.removeInvoice(customerId);
    }

    @Override
    public void updateInvoice(ReqData data) {
        inputUseCase.updateInvoice(data);
    }
}

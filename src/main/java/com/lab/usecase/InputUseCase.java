package com.lab.usecase;

public interface InputUseCase {
    void addInvoice(ReqData data);
    void removeInvoice(String customerId);
    void updateInvoice(ReqData data);
}

package com.frequentis.java.training.casademarcat.model.payment;

public interface PaymentDevice {
    public void removeAmount(double amount) throws PaymentException;

    public String getName();
}

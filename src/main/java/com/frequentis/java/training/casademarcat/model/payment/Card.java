package com.frequentis.java.training.casademarcat.model.payment;

public class Card implements PaymentDevice {
    @Override
    public void removeAmount(double amount) throws PaymentException {
        // TODO: remove from card the amount
    }

    @Override
    public String getName() {
        return "CARD";
    }
}

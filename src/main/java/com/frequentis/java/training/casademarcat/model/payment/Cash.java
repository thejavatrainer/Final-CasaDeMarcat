package com.frequentis.java.training.casademarcat.model.payment;

public class Cash implements PaymentDevice {
    private double myAmount;

    public Cash(double myAmount) {
        this.myAmount = myAmount;
    }

    @Override
    public void removeAmount(double amount) throws PaymentException {
        // TODO: remove the amount of the cash from the wallet
        myAmount -= amount;
        //System.out.printf("Paid %.2f with CASH! Remained %.2f\r\n", amount, myAmount);
    }

    @Override
    public String getName() {
        return "CASH";
    }
}

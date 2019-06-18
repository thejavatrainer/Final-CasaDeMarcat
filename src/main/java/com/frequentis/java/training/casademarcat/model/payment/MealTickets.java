package com.frequentis.java.training.casademarcat.model.payment;

public class MealTickets implements PaymentDevice {
    private final int count;
    private double valuePerItem;

    public MealTickets(int count, double valuePerItem) {
        this.count = count;
        this.valuePerItem = valuePerItem;
    }


    @Override
    public void removeAmount(double amount) throws PaymentException {
        //TODO: handle payment
        double myValue = count * valuePerItem;
        if (myValue < amount) {
            throw new PaymentException("Not enough Meal Tickets!");
        }
        if (myValue - amount >= 1) {
            throw new PaymentException("You must pay an exact amount! Current amount tickets value is:" + myValue);
        }
    }

    @Override
    public String getName() {
        return "MealTicket";
    }
}

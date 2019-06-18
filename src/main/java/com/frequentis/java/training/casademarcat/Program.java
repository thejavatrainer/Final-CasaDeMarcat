package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Cora;
import com.frequentis.java.training.casademarcat.model.payment.Cash;
import com.frequentis.java.training.casademarcat.model.payment.PaymentException;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        Cora cora = new Cora();
        Cashier cashier = new Cashier();
        // on marked open, cashier is filled up with necessary information
        cora.initCashier(cashier);

        cashier.buyProducts(Arrays.asList("Lapte Napolact", "Beciul Domnesc 0.7L", "Lacrima lui Ovidiu 0.7L"));

        try {
            cashier.payProducts(new Cash(55.0), cashier.getTotal());
            cashier.printReceipt();
        } catch (PaymentException e) {
            e.printStackTrace(System.err);
        }
    }
}

package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Product;
import com.frequentis.java.training.casademarcat.model.payment.PaymentDevice;

import java.util.List;
import java.util.Map;

public class ReceiptPrinter {
    private static final String PAD = "%-40s";

    public void printReceipt(double totalPrice, List<Product> productsInProgress,
                             Map<PaymentDevice, Double> paymentsUsed) {
        printMarketHeader();
        printProducts(productsInProgress);
        System.out.println();
        printTotal(totalPrice);
        System.out.println();
        printPayments(paymentsUsed);
        System.out.println("Have a good day!");
    }

    private void printMarketHeader() {
        System.out.println("rSzabi Market:");
    }

    private void printProducts(List<Product> productsInProgress) {
        for (Product product : productsInProgress) {
            System.out.printf(PAD + "%.2f\r\n", "\t" + product.getName(), product.getPrice());
            printPromosIfAvailable(product);
        }
    }

    private void printPromosIfAvailable(Product product) {
        Map<String, Double> appliedPromos = product.getAppliedPromos();
        if (!appliedPromos.isEmpty()) {
            for (String appliedPromo : appliedPromos.keySet()) {
                System.out.printf(PAD + "%.2f\r\n", "\t\t" + appliedPromo, -appliedPromos.get(appliedPromo));
            }
        }
    }

    private void printTotal(double totalPrice) {
        System.out.printf(PAD + "%.2f\r\n", "Total:", totalPrice);
    }

    private void printPayments(Map<PaymentDevice, Double> paymentsUsed) {
        System.out.println("Paid with:");
        for (PaymentDevice device : paymentsUsed.keySet()) {
            System.out.printf(PAD + "%.2f\r\n", "\t" + device.getName(), paymentsUsed.get(device));
        }
        System.out.println();
    }
}

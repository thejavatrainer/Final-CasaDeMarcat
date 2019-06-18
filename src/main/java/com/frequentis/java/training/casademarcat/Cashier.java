package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Product;
import com.frequentis.java.training.casademarcat.model.payment.PaymentDevice;
import com.frequentis.java.training.casademarcat.model.payment.PaymentException;
import com.frequentis.java.training.casademarcat.model.promo.Promo;

import java.util.*;

public class Cashier {
    private final ReceiptPrinter receiptPrinter;

    private Map<PaymentDevice, Double> paymentsUsed;
    private Map<String, Product> registeredProducts;
    private List<Promo> promotions;

    private List<Product> productsInProgress;
    private double totalPrice;
    private double paidPrice;


    public Cashier() {
        receiptPrinter = new ReceiptPrinter();
        registeredProducts = new HashMap<>();
        promotions = new ArrayList<>();
        productsInProgress = new ArrayList<>();
        totalPrice = 0;
        paidPrice = 0;
        paymentsUsed = new LinkedHashMap<>();
    }

    public void cancelTransaction() {
        productsInProgress.clear();
        totalPrice = 0;
        paidPrice = 0;
        paymentsUsed.clear();
    }

    public void registerProduct(Product product) throws ProductAlreadyRegisteredException {
        if (registeredProducts.containsKey(product.getName())) {
            throw new ProductAlreadyRegisteredException(product);
        }
        registeredProducts.put(product.getName(), product);
    }

    public void unregisterProduct(Product product) throws ProductNotRegisteredException {
        if (!registeredProducts.containsKey(product.getName())) {
            throw new ProductNotRegisteredException(product);
        }
    }

    public void registerPromo(Promo promo) {
        promotions.add(promo);
    }

    public void unregisterPromo(Promo promo) {
        promotions.remove(promo);
    }

    public void buyProducts(List<String> productsToBuy) {
        for (String product : productsToBuy) {
            buyProduct(registeredProducts.get(product));
        }
    }

    private void buyProduct(Product productToBuy) {
        productsInProgress.add(productToBuy);
        productToBuy.setPromoPrice(getPromoPrice(productToBuy));
        totalPrice += productToBuy.getPromoPrice();
    }

    private double getPromoPrice(Product productToBuy) {
        double price = productToBuy.getPrice();
        for (Promo promo : promotions) {
            if (promo.appliesTo(productToBuy)) {
                double promoPrice = promo.getPriceFor(productToBuy);
                productToBuy.applyPromo(promo.getPromoName(), price - promoPrice);
                price = promoPrice;
                break;
            }
        }
        return price;
    }

    public double getTotal() {
        return totalPrice;
    }

    public void removeProducts(List<String> productsToRemove) {
        for (String product : productsToRemove) {
            removeProduct(registeredProducts.get(product));
        }
    }

    private void removeProduct(Product productToRemove) {
        totalPrice -= productToRemove.getPromoPrice();
        productsInProgress.remove(productToRemove);
    }

    public void payProducts(PaymentDevice device, double amount) throws PaymentException {
        device.removeAmount(amount);
        paymentsUsed.put(device, amount);
        paidPrice += amount;
    }

    private void finishPayment() throws PaymentException {
        if (totalPrice - paidPrice > 0) {
            throw new PaymentException("You didn't finished paying your goods!");
        }
    }

    public void printReceipt() throws PaymentException {
        finishPayment();
        receiptPrinter.printReceipt(totalPrice, productsInProgress, paymentsUsed);
    }
}

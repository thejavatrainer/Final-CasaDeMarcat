package com.frequentis.java.training.casademarcat.model.promo;

import com.frequentis.java.training.casademarcat.model.Product;

public class AlcoholPromoWithTwoProducts extends Promo {
    private final double multiplier;
    private Product lastProduct;

    public AlcoholPromoWithTwoProducts(int id, String promoName, String promoDescription, double multiplier) {
        super(id, promoName, promoDescription);
        this.multiplier = multiplier;
    }

    @Override
    public boolean appliesTo(Product productToBuy) {
        if (productToBuy.getProductGroup().getGroupName().equals("Alcohol")) {
            if (lastProduct == null) {
                lastProduct = productToBuy;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public double getPriceFor(Product productToBuy) {
        if (productToBuy.getProductGroup().getGroupName().equals("Alcohol") && (lastProduct != null)) {
            return productToBuy.getPrice() * multiplier;
        }
        return productToBuy.getPrice();
    }
}

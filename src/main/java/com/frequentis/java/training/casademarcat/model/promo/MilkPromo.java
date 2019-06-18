package com.frequentis.java.training.casademarcat.model.promo;

import com.frequentis.java.training.casademarcat.model.Product;

public class MilkPromo extends Promo {
    private final double multiplier;

    public MilkPromo(int id, String promoName, String promoDescription, double multiplier) {
        super(id, promoName, promoDescription);
        this.multiplier = multiplier;
    }

    @Override
    public boolean appliesTo(Product productToBuy) {
        return productToBuy.getName().toLowerCase().contains("milk");
    }

    @Override
    public double getPriceFor(Product productToBuy) {
        return productToBuy.getPrice() * multiplier;
    }
}

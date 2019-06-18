package com.frequentis.java.training.casademarcat.model.promo;

import com.frequentis.java.training.casademarcat.model.Product;

import java.util.Objects;

public abstract class Promo {
    private final int id;

    private String promoName;
    private String promoDescription;

    public Promo(int id, String promoName, String promoDescription) {
        this.id = id;
        this.promoName = promoName;
        this.promoDescription = promoDescription;
    }

    public int getId() {
        return id;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promo promo = (Promo) o;
        return id == promo.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public abstract boolean appliesTo(Product productToBuy);

    public abstract double getPriceFor(Product productToBuy);
}

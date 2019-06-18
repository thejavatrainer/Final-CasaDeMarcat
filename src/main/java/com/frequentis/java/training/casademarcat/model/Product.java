package com.frequentis.java.training.casademarcat.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Product {
    private final int id;
    private final ProductGroup productGroup;
    private Map<String, Double> appliedPromos;
    private String name;
    private double price;
    private double promoPrice;

    public Product(int id, ProductGroup productGroup, String name, double price) {
        this.id = id;
        this.productGroup = productGroup;
        this.name = name;
        this.price = price;
        this.appliedPromos = new LinkedHashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public double getPromoPrice() {
        return promoPrice;
    }

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setPromoPrice(double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public void applyPromo(String message, double value) {
        appliedPromos.put(message, value);
    }

    public Map<String, Double> getAppliedPromos() {
        return Collections.unmodifiableMap(appliedPromos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(productGroup, product.productGroup);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productGroup='" + productGroup.getGroupName() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, productGroup);
    }

}

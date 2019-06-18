package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Product;

public abstract class ProductAwareException extends Exception {
    private final Product product;

    public ProductAwareException(String message, Product product) {
        super(String.format(message, product));
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }
}

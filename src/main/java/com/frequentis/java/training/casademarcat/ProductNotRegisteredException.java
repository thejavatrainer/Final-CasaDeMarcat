package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Product;

public class ProductNotRegisteredException extends ProductAwareException {
    public ProductNotRegisteredException(Product product) {
        super("NOT Registered Product:%s", product);
    }
}

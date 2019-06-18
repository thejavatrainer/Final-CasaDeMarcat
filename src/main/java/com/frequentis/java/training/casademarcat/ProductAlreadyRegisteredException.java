package com.frequentis.java.training.casademarcat;

import com.frequentis.java.training.casademarcat.model.Product;

public class ProductAlreadyRegisteredException extends ProductAwareException {

    public ProductAlreadyRegisteredException(Product product) {
        super("Already Registered Product:%s", product);
    }
}

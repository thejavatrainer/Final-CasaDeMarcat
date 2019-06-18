package com.frequentis.java.training.casademarcat.model;

import com.frequentis.java.training.casademarcat.Cashier;
import com.frequentis.java.training.casademarcat.ProductAlreadyRegisteredException;
import com.frequentis.java.training.casademarcat.model.promo.AlcoholPromoWithTwoProducts;
import com.frequentis.java.training.casademarcat.model.promo.MilkPromo;
import com.frequentis.java.training.casademarcat.model.promo.Promo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cora implements CashierInitialiser {
    private final Map<String, ProductGroup> productGroups;
    private final List<Product> products;
    private final List<Promo> promos;

    private int groupId;
    private int productId;

    public Cora() {
        productGroups = new HashMap<>();
        products = new ArrayList<>();
        promos = new ArrayList<>();
        groupId = 0;
        productId = 0;
    }

    @Override
    public void initCashier(Cashier cashier) {
        initGroups();
        initProducts();
        initPromos();

        try {
            for (Product product : products) {
                cashier.registerProduct(product);
            }
        } catch (ProductAlreadyRegisteredException e) {
            throw new RuntimeException(e);
        }
        for (Promo promo : promos) {
            cashier.registerPromo(promo);
        }
    }

    private void initProducts() {
        createProduct("Meals", "Lapte Napolact", 5.7);
        createProduct("Meals", "Paine Panemar Negru", 4.2);
        createProduct("Meals", "Milka Lapte", 5.0);
        createProduct("AutoMoto", "Valeo 115cm", 45.0);
        createProduct("Alcohol", "Beciul Domnesc 0.7L", 17.0);
        createProduct("Alcohol", "Lacrima lui Ovidiu 0.7L", 37.0);
    }

    private void initGroups() {
        createGroup("Meals", "Group for meals");
        createGroup("AutoMoto", "Group for automotive goods");
        createGroup("Alcohol", "Group for alcoholic drinks");
    }

    private void initPromos() {
        Promo milkPromo15 = new MilkPromo(1, "Promo Lapte",
                "Reducere la lapte 15%", 0.85);

        Promo onePlusOneWinePromo50 = new AlcoholPromoWithTwoProducts(1, "Promo Vin",
                "Reducerea la al doilea vin cu 50%", 0.50);

        promos.add(milkPromo15);
        promos.add(onePlusOneWinePromo50);
    }

    private void createProduct(String groupName, String productName, double price) {
        products.add(new Product(++productId, productGroups.get(groupName), productName, price));
    }

    private void createGroup(String groupName, String groupDescription) {
        productGroups.put(groupName, new ProductGroup(++groupId, groupName, groupDescription));
    }
}

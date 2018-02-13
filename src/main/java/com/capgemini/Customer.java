package com.capgemini;

import java.util.ArrayList;

public abstract class Customer {

    protected String name;

    public Customer(String name) {
        this.name = name;
    }

    private ArrayList<Product> products = new ArrayList<Product>();

    public abstract void addProduct(Product product);

    public ArrayList<Product> getProducts() {
        return products;
    }

    public abstract String greeting();
}

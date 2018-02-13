package com.capgemini;

public class RegularCustomer extends Customer {

    public RegularCustomer(String name) {
        super(name);
    }

    public void addProduct(Product product) {
        super.getProducts().add(product);
    }

    public String greeting() {
        return "Welcome back " + super.name;
    }
}

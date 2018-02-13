package com.capgemini;

import java.util.ArrayList;

/**
 * Welcome to the Appie Happie
 */

public class App {

    public static void main(String[] args) {

        // Create new products
        Product A = new Product("Robijn", 3);
        Product B = new Product("Brinta", 2);
        Product C = new Product("Chinese Groenten", 5);
        Product D = new Product("Kwark", 2);
        Product E = new Product("Luiers", 10);

        // Put them in a list
        ArrayList<Product> allProducts = new ArrayList<Product>();
        allProducts.add(A);
        allProducts.add(B);
        allProducts.add(C);
        allProducts.add(D);
        allProducts.add(E);

        // Create new Register
        IRegister register = new Register();

        // Initialize register
        register.initialize(allProducts);

        // Create new Customer
        Customer customer = new RegularCustomer("Winterklaas");

        customer.addProduct(B);
        customer.addProduct(B);
        customer.addProduct(A);
        customer.addProduct(E);
        customer.addProduct(B);
        customer.addProduct(E);
        customer.addProduct(C);
        customer.addProduct(C);
        customer.addProduct(E);
        customer.addProduct(E);

        register.checkout(customer);
    }
}

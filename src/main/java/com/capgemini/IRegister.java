package com.capgemini;

import java.util.ArrayList;

public interface IRegister {

    void initialize(ArrayList<Product> allProducts, ArrayList<Discount> discounts);

    void checkout(Customer customer);

}

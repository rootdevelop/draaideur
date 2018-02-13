package com.capgemini;

import java.util.ArrayList;

public interface IRegister {

    void initialize(ArrayList<Product> allProducts);

    void checkout(Customer customer);

}

package com.capgemini;

import java.util.ArrayList;

public class Register implements IRegister {

    private ArrayList<Product> allProducts = new ArrayList<Product>();

    public void initialize(ArrayList<Product> productList) {
        this.allProducts = productList;
    }

    public void checkout(Customer customer) {

        System.out.println();
        System.out.println(customer.greeting());
        System.out.println("---------------------------------------------------------------------------------");

        int discount = calculateDiscount(customer.getProducts());

        int total = calculateTotal(customer.getProducts(), discount);

        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("Total: € " + total);
        System.out.println("Discount: € " + discount);
        System.out.println();
        System.out.println("Thank you for ordering");

        System.out.println("---------------------------------------------------------------------------------");

    }

    public int calculateTotal(ArrayList<Product> products, int discount) {

        int total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total - discount;

    }

    public int calculateDiscount(ArrayList<Product> products) {

        int discount = 0;

        for (Product product : this.allProducts) {

            int productCount = 0;

            for (Product customerProduct : products) {

                if (customerProduct.equals(product)) {
                    productCount++;
                }
            }

            int productDiscount = getProductDiscount(product, productCount);
            discount += productDiscount;


            if (productCount != 0) {
                System.out.println("BEEP.. " + productCount + "x " + product.getName() + " scanned (regular price: € " + (product.getPrice() * productCount) + " discount: € " + productDiscount + ")");
            }
        }

        return discount;

    }

    private int getProductDiscount(Product product, int count) {

        /**
         * Product A gives 20 discount per 3 items
         */
        if (product.getName().equals("Robijn"))
            return applyDiscount(count, 3, 2);

        /**
         * Product A gives 20 discount per 3 items
         */
        if (product.getName().equals("Brinta"))
            return applyDiscount(count, 2, 1);

        /**
         * Product A gives 20 discount per 3 items
         */
        if (product.getName().equals("Luiers"))
            return applyDiscount(count, 4, 10);


        return 0;

    }

    private int applyDiscount(int productCount, int discountCount, int discountPricePerDiscountCount) {


        int offers = productCount / discountCount;

        return offers * discountPricePerDiscountCount;

    }

}

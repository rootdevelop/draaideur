package com.capgemini;

import java.util.ArrayList;

public class Register implements IRegister {

    private ArrayList<Product> allProducts = new ArrayList<Product>();
    private ArrayList<Discount> discounts = new ArrayList<Discount>();

    public void initialize(ArrayList<Product> productList, ArrayList<Discount> discounts) {
        this.allProducts = productList;
        this.discounts = discounts;
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

        for(Discount discount : discounts) {
            if (product.equals(discount.getProduct()))
                return applyDiscount(count, discount.getCount(), discount.getDiscount());
        }

        return 0;

    }

    private int applyDiscount(int productCount, int discountCount, int discountPricePerDiscountCount) {

        int offers = productCount / discountCount;

        return offers * discountPricePerDiscountCount;

    }

}

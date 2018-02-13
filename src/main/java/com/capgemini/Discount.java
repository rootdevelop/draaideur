package com.capgemini;

public class Discount {

    private Product product;

    private int count;

    private int discount;

    public Discount(Product product, int count, int discount) {
        this.product = product;
        this.count = count;
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

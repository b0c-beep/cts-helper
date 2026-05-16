package ro.ase.csie.cts.tests.test2.sub1_strategy.models;

import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IProduct;

public class Product implements IProduct {
    private String name;
    private float price;
    private int reviews;

    public Product(String name, float price, int reviews) {
        this.name = name;
        this.price = price;
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getReviews() {
        return reviews;
    }

    @Override
    public void showProduct() {
        System.out.println("PRODUCT: " + name);
        System.out.println("PRICE: " + price);
        System.out.println("NB OF REVIEWS: " + reviews);
        System.out.println();
    }
}

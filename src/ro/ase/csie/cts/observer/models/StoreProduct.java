package ro.ase.csie.cts.observer.models;

import ro.ase.csie.cts.observer.abstracts.AObservable;

public class StoreProduct extends AObservable {
    private String productName;
    private double currentPrice;

    public StoreProduct(String productName, double currentPrice) {
        this.productName = productName;
        this.currentPrice = currentPrice;
    }

    public void setPrice(double price) {
        if(price < currentPrice) {
            notifySubscribers("PRICE WENT DOWN FOR " + productName);
        }
        this.currentPrice = price;
    }
}

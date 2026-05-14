package ro.ase.csie.cts.observer;

import ro.ase.csie.cts.observer.abstracts.AObservable;
import ro.ase.csie.cts.observer.abstracts.IObserver;
import ro.ase.csie.cts.observer.models.LoyalCustomer;
import ro.ase.csie.cts.observer.models.StoreProduct;

public class Main {
    public static void main(String[] args) {
        StoreProduct product1 = new StoreProduct("iphone", 1000.0);
        IObserver customer1 = new LoyalCustomer("george");
        IObserver customer2 = new LoyalCustomer("alex");
        IObserver customer3 = new LoyalCustomer("maria");
        product1.subscribe(customer1);
        product1.subscribe(customer2);

        product1.setPrice(1200.0);
        System.out.println();
        product1.setPrice(800.0);
        System.out.println();
        product1.unsubscribe(customer2);
        product1.setPrice(700);
        System.out.println();
    }
}

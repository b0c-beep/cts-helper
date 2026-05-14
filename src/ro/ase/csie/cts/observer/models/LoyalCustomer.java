package ro.ase.csie.cts.observer.models;

import ro.ase.csie.cts.observer.abstracts.IObserver;

public class LoyalCustomer implements IObserver {
    private String clientName;

    public LoyalCustomer(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void getNotification(String message) {
        System.out.println("TO " + clientName + " -> " + message);
    }
}

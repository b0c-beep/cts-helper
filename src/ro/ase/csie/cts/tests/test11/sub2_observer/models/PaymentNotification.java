package ro.ase.csie.cts.tests.test11.sub2_observer.models;

import ro.ase.csie.cts.tests.test11.sub2_observer.abstracts.INotification;

public class PaymentNotification implements INotification {
    private String phone;

    public PaymentNotification(String phone) {
        this.phone = phone;
    }

    @Override
    public void paymentOutcome(String message) {
        System.out.println("ON " + phone);
        System.out.println(message);
    }
}

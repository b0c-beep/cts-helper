package ro.ase.csie.cts.tests.test11.sub2_observer;

import ro.ase.csie.cts.tests.test11.sub2_observer.abstracts.AObservablePayment;
import ro.ase.csie.cts.tests.test11.sub2_observer.abstracts.INotification;
import ro.ase.csie.cts.tests.test11.sub2_observer.models.Payment;
import ro.ase.csie.cts.tests.test11.sub2_observer.models.PaymentNotification;

public class Main {
    public static void main(String[] args) {
        INotification n1 = new PaymentNotification("phone1");
        INotification n2 = new PaymentNotification("phone2");
        INotification n3 = new PaymentNotification("phone3");

        AObservablePayment pay = new Payment();
        pay.pay("test.com", 20.0f);

        pay.turnOnNotifications();
        pay.subscribe(n1);
        pay.subscribe(n2);
        pay.subscribe(n3);

        pay.pay("test.com", 30.0f);

        pay.turnOffNotifications();

        pay.pay("test.com", 100.0f);
    }
}

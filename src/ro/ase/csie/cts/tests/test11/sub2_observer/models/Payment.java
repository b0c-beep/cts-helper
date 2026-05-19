package ro.ase.csie.cts.tests.test11.sub2_observer.models;

import ro.ase.csie.cts.tests.test11.sub1_proxy.abstracts.IPayment;
import ro.ase.csie.cts.tests.test11.sub2_observer.abstracts.AObservablePayment;

public class Payment extends AObservablePayment {

    @Override
    public boolean pay(String domain, double amount) {
        System.out.println("PAYING " + amount + " TO " + domain);
        notifyAllSubscribers(domain, amount, true);
        return true;
    }
}

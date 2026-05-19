package ro.ase.csie.cts.tests.test11.sub1_proxy.models;

import ro.ase.csie.cts.tests.test11.sub1_proxy.abstracts.IPayment;

public class Payment implements IPayment {
    @Override
    public boolean pay(String domain, double amount) {
        System.out.println("PAYING " + amount + " TO " + domain);
        return true;
    }
}

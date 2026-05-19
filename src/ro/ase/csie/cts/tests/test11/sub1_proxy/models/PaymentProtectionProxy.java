package ro.ase.csie.cts.tests.test11.sub1_proxy.models;

import ro.ase.csie.cts.tests.test11.sub1_proxy.abstracts.IPayment;

import java.util.ArrayList;
import java.util.List;

public class PaymentProtectionProxy implements IPayment {
    private IPayment payment;
    private static final List<String> blacklistedDomains = List.of("ghiseul-ro.online", "booki.ng", "1ng.ro");

    public PaymentProtectionProxy(IPayment payment) {
        this.payment = payment;
    }

    @Override
    public boolean pay(String domain, double amount) {
        if (!blacklistedDomains.contains(domain)) {
            return payment.pay(domain, amount);
        }
        else throw new UnsupportedOperationException("Domain is blacklisted");
    }
}

package ro.ase.csie.cts.tests.test11.sub1_proxy;

import ro.ase.csie.cts.tests.test11.sub1_proxy.abstracts.IPayment;
import ro.ase.csie.cts.tests.test11.sub1_proxy.models.Payment;
import ro.ase.csie.cts.tests.test11.sub1_proxy.models.PaymentProtectionProxy;

public class Main {
    public static void main(String[] args) {
        IPayment pay1 = new Payment();
        IPayment proxy = new PaymentProtectionProxy(pay1);

        pay1.pay("domain-legit.ro", 200.0f);
        pay1.pay("scam.ro", 150.0f);

        proxy.pay("domain-legit.ro", 55.0f);
        proxy.pay("booki.ng", 25.0f);

    }
}

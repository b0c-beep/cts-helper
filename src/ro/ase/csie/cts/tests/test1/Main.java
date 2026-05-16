package ro.ase.csie.cts.tests.test1;

import ro.ase.csie.cts.tests.test1.abstracts.IHospital;
import ro.ase.csie.cts.tests.test1.models.Hospital;
import ro.ase.csie.cts.tests.test1.models.HospitalGuest;
import ro.ase.csie.cts.tests.test1.models.RestrictedHospitalProxy;

public class Main {
    public static void main(String[] args) {
        IHospital hospital = new Hospital("St. Bonaventure");
        RestrictedHospitalProxy proxy = new RestrictedHospitalProxy(hospital);

        HospitalGuest g1 = new HospitalGuest("Mario", true);
        HospitalGuest g2 = new HospitalGuest("George", false);
        HospitalGuest g3 = new HospitalGuest("Rebecca", true);
        HospitalGuest g4 = new HospitalGuest("Andrew", true);

        proxy.addGuestInQueue(g1);
        proxy.addGuestInQueue(g2);
        proxy.addGuestInQueue(g3);
        proxy.grantAccess();
        System.out.println();

        proxy.grantAccess();
        System.out.println();

        proxy.addGuestInQueue(g4);
        proxy.grantAccess();
    }
}

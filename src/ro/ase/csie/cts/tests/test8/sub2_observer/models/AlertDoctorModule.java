package ro.ase.csie.cts.tests.test8.sub2_observer.models;

import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.INotificationModule;

public class AlertDoctorModule implements INotificationModule {
    @Override
    public void refresh(String message) {
        System.out.println(message);
        System.out.println("ALERTING current patient doctor about status");
    }
}

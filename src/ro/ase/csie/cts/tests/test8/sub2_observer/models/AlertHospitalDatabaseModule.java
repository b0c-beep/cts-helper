package ro.ase.csie.cts.tests.test8.sub2_observer.models;

import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.INotificationModule;

public class AlertHospitalDatabaseModule implements INotificationModule {
    @Override
    public void refresh(String message) {
        System.out.println(message);
        System.out.println("ALERTING hospital database about patient status change, database is being updated");
    }
}

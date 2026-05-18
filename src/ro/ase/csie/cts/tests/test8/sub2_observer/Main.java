package ro.ase.csie.cts.tests.test8.sub2_observer;

import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.IMonitoredPatient;
import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.INotificationModule;
import ro.ase.csie.cts.tests.test8.sub2_observer.enums.StatusType;
import ro.ase.csie.cts.tests.test8.sub2_observer.models.AlertDoctorModule;
import ro.ase.csie.cts.tests.test8.sub2_observer.models.AlertFamilyModule;
import ro.ase.csie.cts.tests.test8.sub2_observer.models.AlertHospitalDatabaseModule;
import ro.ase.csie.cts.tests.test8.sub2_observer.models.MonitoredPatient;

public class Main {
    public static void main(String[] args) {
        MonitoredPatient patient = new MonitoredPatient("john", StatusType.NEEDS_CARE);
        INotificationModule mod1 = new AlertDoctorModule();
        INotificationModule mod2 = new AlertFamilyModule();
        INotificationModule mod3 = new AlertHospitalDatabaseModule();

        patient.addModule(mod1);
        patient.addModule(mod3);

        patient.setPatientStatus(StatusType.FULL_MONITORING);
        System.out.println();

        patient.addModule(mod2);

        patient.setPatientStatus(StatusType.STABLE);
        System.out.println();

        patient.removeModule(mod1);
        patient.setPatientStatus(StatusType.NEEDS_CARE);
        System.out.println();

    }
}

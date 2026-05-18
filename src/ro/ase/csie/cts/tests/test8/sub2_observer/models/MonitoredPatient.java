package ro.ase.csie.cts.tests.test8.sub2_observer.models;

import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.IMonitoredPatient;
import ro.ase.csie.cts.tests.test8.sub2_observer.abstracts.INotificationModule;
import ro.ase.csie.cts.tests.test8.sub2_observer.enums.StatusType;

import java.util.ArrayList;
import java.util.List;

public class MonitoredPatient implements IMonitoredPatient {
    private String patientName;
    private StatusType patientStatus;
    private List<INotificationModule> modules = new ArrayList<>();

    public MonitoredPatient(String patientName, StatusType patientStatus) {
        this.patientName = patientName;
        this.patientStatus = patientStatus;
    }

    public void setPatientStatus(StatusType patientStatus) {
        this.patientStatus = patientStatus;
        notifyModules();
    }

    @Override
    public void addModule(INotificationModule module) {
        modules.add(module);
    }

    @Override
    public void removeModule(INotificationModule module) {
        modules.remove(module);
    }

    @Override
    public void notifyModules() {
        modules.forEach(m -> m.refresh("STATUS CHANGE! Patient: " + this.patientName + " has new status: " + patientStatus));
    }
}

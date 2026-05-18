package ro.ase.csie.cts.tests.test8.sub2_observer.abstracts;

public interface IMonitoredPatient {
    void addModule(INotificationModule module);
    void removeModule(INotificationModule module);
    void notifyModules();
}

package ro.ase.csie.cts.generated_tests.test2.sub2_facade.abstracts;

public interface IReception {
    void processCheckIn(String clientName, int cameraNumber);
    void processCheckOut(String clientName);
    void solicitSupplementaryService(String clientName, String service);
}

package ro.ase.csie.cts.generated_tests.test2.sub2_facade.models;

import ro.ase.csie.cts.generated_tests.test2.sub2_facade.abstracts.IReception;

public class Reception implements IReception {
    private RezervationSystem rezervationSystem;
    private ReceiptSystem receiptSystem;
    private RoomCleaningSystem roomCleaningSystem;
    private ServiceSystem serviceSystem;

    public Reception(RezervationSystem rezervationSystem, ReceiptSystem receiptSystem, RoomCleaningSystem roomCleaningSystem, ServiceSystem serviceSystem) {
        this.rezervationSystem = rezervationSystem;
        this.receiptSystem = receiptSystem;
        this.roomCleaningSystem = roomCleaningSystem;
        this.serviceSystem = serviceSystem;
    }

    @Override
    public void processCheckIn(String clientName, int cameraNumber) {
        roomCleaningSystem.prepareRoom(cameraNumber);
        rezervationSystem.checkInClient(clientName, cameraNumber);
    }

    @Override
    public void processCheckOut(String clientName) {
        receiptSystem.generateReceipt(clientName, rezervationSystem.getRoom(clientName));
        rezervationSystem.checkOutClient(clientName);
        roomCleaningSystem.cleanRoom(rezervationSystem.getRoom(clientName));
    }

    @Override
    public void solicitSupplementaryService(String clientName, String service) {
        serviceSystem.sendService(clientName, service);
    }
}

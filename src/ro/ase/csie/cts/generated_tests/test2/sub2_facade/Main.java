package ro.ase.csie.cts.generated_tests.test2.sub2_facade;

import ro.ase.csie.cts.generated_tests.test2.sub2_facade.models.*;

public class Main {
    public static void main(String[] args) {
        RezervationSystem rez = new RezervationSystem();
        ReceiptSystem rec = new ReceiptSystem();
        RoomCleaningSystem cln = new RoomCleaningSystem();
        ServiceSystem srv = new ServiceSystem();

        Reception reception = new Reception(rez, rec, cln, srv);

        reception.processCheckIn("john", 12);
        reception.processCheckIn("alice", 5);

        reception.solicitSupplementaryService("alice", "transport");

        reception.processCheckOut("john");
        reception.processCheckOut("alice");
    }
}

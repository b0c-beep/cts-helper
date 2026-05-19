package ro.ase.csie.cts.generated_tests.test2.sub2_facade.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RezervationSystem {
    private Map<String, Integer> clients = new HashMap<>();

    public void checkInClient(String name, int room) {
        clients.put(name, room);
        System.out.println("CLIENT " + name + " IS CHECKED IN ROOM " + room);
    }

    public void checkOutClient(String name) {
        clients.remove(clients.get(name));
        System.out.println("CLIENT " + name + " HAS BEEN CHECKED OUT");
    }

    public int getRoom(String name) {
        return clients.get(name).intValue();
    }
}

package ro.ase.csie.cts.chain.models;

import ro.ase.csie.cts.chain.abstracts.ADeliveryHandler;

public class DeliveryTruck extends ADeliveryHandler {
    @Override
    public void getDelivery(float weight) {
        System.out.println("DELIVERY DONE WITH THE TRUCK");
    }
}

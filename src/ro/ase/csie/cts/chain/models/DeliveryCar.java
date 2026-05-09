package ro.ase.csie.cts.chain.models;

import ro.ase.csie.cts.chain.abstracts.ADeliveryHandler;

public class DeliveryCar extends ADeliveryHandler {
    public static final int CAR_LIMIT = 20;

    @Override
    public void getDelivery(float weight) {
        if (weight < CAR_LIMIT) {
            System.out.println("DELIVERY DONE WITH THE CAR");
        }
        else {
            if (nextHandler != null) {
                nextHandler.getDelivery(weight);
            }
        }
    }
}

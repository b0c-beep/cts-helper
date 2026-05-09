package ro.ase.csie.cts.chain.models;

import ro.ase.csie.cts.chain.abstracts.ADeliveryHandler;

public class DeliveryBicycle extends ADeliveryHandler {
    public static final int BICYCLE_LIMIT = 3;

    @Override
    public void getDelivery(float weight) {
        if (weight < BICYCLE_LIMIT) {
            System.out.println("DELIVERY DONE WITH THE BICYCLE");
        }
        else {
            if (nextHandler != null) {
                nextHandler.getDelivery(weight);
            }
        }
    }
}

package ro.ase.csie.cts.chain;

import ro.ase.csie.cts.chain.abstracts.ADeliveryHandler;
import ro.ase.csie.cts.chain.models.DeliveryBicycle;
import ro.ase.csie.cts.chain.models.DeliveryCar;
import ro.ase.csie.cts.chain.models.DeliveryTruck;

public class Main {
    public static void main(String[] args) {
        ADeliveryHandler bicycle = new DeliveryBicycle();
        ADeliveryHandler car = new DeliveryCar();
        ADeliveryHandler truck = new DeliveryTruck();
        bicycle.setNextHandler(car);
        car.setNextHandler(truck);

        bicycle.getDelivery(2);
        bicycle.getDelivery(10);
        bicycle.getDelivery(50);
        bicycle.getDelivery(1);
    }
}

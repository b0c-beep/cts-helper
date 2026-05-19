package ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models;

import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.AHotelRoomDecorator;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.IHotelRoom;

public class ParkingHotelRoomDecorator extends AHotelRoomDecorator {
    private static final double PARKING_FEE = 7.3f;

    public ParkingHotelRoomDecorator(IHotelRoom room) {
        super(room);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append("WITH PARKING\n");
        return sb.toString();
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight() + PARKING_FEE;
    }
}

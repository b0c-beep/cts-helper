package ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models;

import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.AHotelRoomDecorator;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.IHotelRoom;

public class BreakfastHotelRoomDecorator extends AHotelRoomDecorator {
    private static final double BREAKFAST_PRICE = 18.5f;

    public BreakfastHotelRoomDecorator(IHotelRoom room) {
        super(room);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append("WITH BREAKFAST\n");
        return sb.toString();
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight() + BREAKFAST_PRICE;
    }
}

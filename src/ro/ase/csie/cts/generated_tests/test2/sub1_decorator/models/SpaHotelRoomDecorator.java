package ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models;

import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.AHotelRoomDecorator;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.IHotelRoom;

public class SpaHotelRoomDecorator extends AHotelRoomDecorator {
    private static final double SPA_ACCESS_PRICE = 34.8f;

    public SpaHotelRoomDecorator(IHotelRoom room) {
        super(room);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(super.getDescription());
        sb.append("WITH SPA ACCESS\n");
        return sb.toString();
    }

    @Override
    public double getPricePerNight() {
        return super.getPricePerNight() + SPA_ACCESS_PRICE;
    }
}

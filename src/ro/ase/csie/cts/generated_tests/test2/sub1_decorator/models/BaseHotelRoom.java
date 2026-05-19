package ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models;

import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.IHotelRoom;

public class BaseHotelRoom implements IHotelRoom {
    private String title;
    private static final double BASE_ROOM_PRICE = 100.0f;

    public BaseHotelRoom(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(title + "\n");
        return sb.toString();
    }

    @Override
    public double getPricePerNight() {
        return BASE_ROOM_PRICE;
    }
}

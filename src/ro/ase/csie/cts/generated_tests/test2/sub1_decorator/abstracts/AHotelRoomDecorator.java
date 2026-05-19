package ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts;

public abstract class AHotelRoomDecorator implements IHotelRoom {
    private IHotelRoom room;

    public AHotelRoomDecorator(IHotelRoom room) {
        this.room = room;
    }

    @Override
    public String getDescription() {
        return room.getDescription();
    }

    @Override
    public double getPricePerNight() {
        return room.getPricePerNight();
    }
}

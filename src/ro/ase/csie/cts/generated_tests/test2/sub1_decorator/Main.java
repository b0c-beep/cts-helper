package ro.ase.csie.cts.generated_tests.test2.sub1_decorator;

import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.abstracts.IHotelRoom;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models.BaseHotelRoom;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models.BreakfastHotelRoomDecorator;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models.ParkingHotelRoomDecorator;
import ro.ase.csie.cts.generated_tests.test2.sub1_decorator.models.SpaHotelRoomDecorator;

public class Main {
    public static void main(String[] args) {
        IHotelRoom room = new BaseHotelRoom("hotel room #1");
        System.out.println(room.getDescription());
        System.out.println(room.getPricePerNight());
        System.out.println();

        IHotelRoom room2 = new BreakfastHotelRoomDecorator(room);
        System.out.println(room2.getDescription());
        System.out.println(room2.getPricePerNight());
        System.out.println();

        IHotelRoom room3 = new SpaHotelRoomDecorator(room2);
        System.out.println(room3.getDescription());
        System.out.println(room3.getPricePerNight());
        System.out.println();

        IHotelRoom room4 = new ParkingHotelRoomDecorator(room3);
        System.out.println(room4.getDescription());
        System.out.println(room4.getPricePerNight());
    }
}

package ro.ase.csie.cts.tests.test1.models;

import ro.ase.csie.cts.tests.test1.abstracts.IHospital;

import java.util.ArrayList;
import java.util.List;

public class RestrictedHospitalProxy implements IHospital {
    private final IHospital hospital;
    private final List<HospitalGuest> guests = new ArrayList<>();

    public RestrictedHospitalProxy(IHospital hospital) {
        this.hospital = hospital;
    }

    public void addGuestInQueue(HospitalGuest guest) {
        guests.add(guest);
    }

    @Override
    public void grantAccess() {
        if (guests.stream().allMatch(HospitalGuest::seeLetter) && guests.size() >= 3) {
            System.out.println("SUITING UP " + guests.size() + " GUESTS WITH EQUIPMENT");
            hospital.grantAccess();
            guests.clear();
        }
        else if (guests.size() < 3) {
            System.out.println("NOT ENOUGH GUESTS");
        }
        else if (!guests.stream().allMatch(HospitalGuest::seeLetter) && !guests.isEmpty()) {
            for (HospitalGuest guest : guests) {
                if (!guest.seeLetter()) {
                    System.out.println("GUEST " + guest.getName() + " DOESNT HAVE LETTER, " + guest.getName() + " IS SHOWN TO THE EXIT");
                    guests.remove(guest);
                }
            }
        }
    }
}

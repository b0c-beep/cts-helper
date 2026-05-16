package ro.ase.csie.cts.tests.test1.models;

public class HospitalGuest {
    private String name;
    private boolean hasLetter;

    public HospitalGuest(String name, boolean hasLetter) {
        this.hasLetter = hasLetter;
        this.name = name;
    }

    public boolean seeLetter() {
        return hasLetter;
    }

    public String getName() {
        return name;
    }
}

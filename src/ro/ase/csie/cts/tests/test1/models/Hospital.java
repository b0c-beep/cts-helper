package ro.ase.csie.cts.tests.test1.models;

import ro.ase.csie.cts.tests.test1.abstracts.IHospital;

public class Hospital implements IHospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    @Override
    public void grantAccess() {
        System.out.println("ACCESS INTO THE " + name + " HOSPITAL");
    }
}

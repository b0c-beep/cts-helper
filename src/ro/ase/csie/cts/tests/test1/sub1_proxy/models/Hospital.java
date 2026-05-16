package ro.ase.csie.cts.tests.test1.sub1_proxy.models;

import ro.ase.csie.cts.tests.test1.sub1_proxy.abstracts.IHospital;

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

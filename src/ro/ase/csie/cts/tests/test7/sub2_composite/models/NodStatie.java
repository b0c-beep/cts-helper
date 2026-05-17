package ro.ase.csie.cts.tests.test7.sub2_composite.models;

import ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts.AbstractAlgoritmRuta;
import ro.ase.csie.cts.tests.test7.sub2_composite.abstracts.AbstractElementTransport;

public class NodStatie implements AbstractElementTransport {
    private String nume;
    private int pasageri;

    public NodStatie(String nume, int pasageri) {
        this.nume = nume;
        this.pasageri = pasageri;
    }

    @Override
    public int calculeazaNumarPasageri() {
        return pasageri;
    }

    @Override
    public boolean verificaCapacitate(int capacitateMaxima) {
        return pasageri <= capacitateMaxima;
    }
}

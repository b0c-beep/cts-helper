package ro.ase.csie.cts.tests.test4.sub1_composite.models;

import ro.ase.csie.cts.tests.test4.sub1_composite.abstracts.ICode;

public class NodFunctie implements ICode {
    private String numeFunctie;
    private int numarApeluriUnsafe;

    public NodFunctie(String numeFunctie, int numarApeluriUnsafe) {
        this.numeFunctie = numeFunctie;
        this.numarApeluriUnsafe = numarApeluriUnsafe;
    }

    @Override
    public int obtineNumarApeluriUnsafe() {
        return numarApeluriUnsafe;
    }

    public String getNumeFunctie() {
        return numeFunctie;
    }
}

package ro.ase.csie.cts.tests.test4.sub1_composite.models;

import ro.ase.csie.cts.tests.test4.sub1_composite.abstracts.ICode;

import java.util.ArrayList;
import java.util.List;

public class NodClasa implements ICode {
    private String numeClasa;
    private List<ICode> children = new ArrayList<>();

    public NodClasa(String numeClasa) {
        this.numeClasa = numeClasa;
    }

    public void adaugaCopil(ICode copil) {
        children.add(copil);
    }

    public void stergeCopil(ICode copil) {
        children.remove(copil);
    }

    public String getNumeClasa() {
        return numeClasa;
    }

    @Override
    public int obtineNumarApeluriUnsafe() {
        return children.stream().mapToInt(ICode::obtineNumarApeluriUnsafe).sum();
    }
}

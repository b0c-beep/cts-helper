package ro.ase.csie.cts.tests.test7.sub2_composite.models;

import ro.ase.csie.cts.tests.test7.sub2_composite.abstracts.AbstractElementTransport;

import java.util.ArrayList;
import java.util.List;

public class NodTransport implements AbstractElementTransport{
    private String nume;
    private List<AbstractElementTransport> statii = new ArrayList<>();

    public NodTransport(String nume) {
        this.nume = nume;
    }

    public void adaugaNod(AbstractElementTransport nod) {
        statii.add(nod);
    }

    public void stergeNod(AbstractElementTransport nod) {
        statii.remove(nod);
    }

    @Override
    public int calculeazaNumarPasageri() {
        return statii.stream().mapToInt(AbstractElementTransport::calculeazaNumarPasageri).sum();
    }

    @Override
    public boolean verificaCapacitate(int capacitateMaxima) {
        return calculeazaNumarPasageri() <= capacitateMaxima;
    }
}

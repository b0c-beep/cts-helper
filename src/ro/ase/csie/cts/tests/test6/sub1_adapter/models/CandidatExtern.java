package ro.ase.csie.cts.tests.test6.sub1_adapter.models;

import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatExtern;

public class CandidatExtern implements AbstractCandidatExtern {
    private String numeCandidat;
    private String[] aptitudini;
    private int aniDeExperienta;

    public CandidatExtern(String numeCandidat, String[] aptitudini, int aniDeExperienta) {
        this.numeCandidat = numeCandidat;
        this.aptitudini = aptitudini;
        this.aniDeExperienta = aniDeExperienta;
    }

    @Override
    public String numeComplet() {
        return numeCandidat;
    }

    @Override
    public int totalAniExperienta() {
        return aniDeExperienta;
    }

    @Override
    public String[] listaCompetente() {
        return aptitudini;
    }
}

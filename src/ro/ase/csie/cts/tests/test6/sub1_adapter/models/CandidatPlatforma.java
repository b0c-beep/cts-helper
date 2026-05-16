package ro.ase.csie.cts.tests.test6.sub1_adapter.models;

import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatPlatforma;

public class CandidatPlatforma implements AbstractCandidatPlatforma {
    private String nume;
    private int aniExperienta;
    private String[] competente;

    public CandidatPlatforma(String nume, int aniExperienta, String[] competente) {
        this.nume = nume;
        this.aniExperienta = aniExperienta;
        this.competente = competente;
    }

    @Override
    public String obtineNume() {
        return nume;
    }

    @Override
    public int obtineAniExperienta() {
        return aniExperienta;
    }

    @Override
    public String[] obtineCompetente() {
        return competente;
    }
}

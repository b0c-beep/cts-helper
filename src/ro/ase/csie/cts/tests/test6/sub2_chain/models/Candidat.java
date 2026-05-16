package ro.ase.csie.cts.tests.test6.sub2_chain.models;

import java.util.ArrayList;
import java.util.List;

public class Candidat {
    private String nume;
    private int aniExperienta;
    private List<String> competente = new ArrayList<>();
    private float asteptareSalariala;
    private boolean deschisLaInterviu;

    public Candidat(String nume, int aniExperienta, List<String> competente, float asteptareSalariala, boolean deschisLaInterviu) {
        this.nume = nume;
        this.aniExperienta = aniExperienta;
        this.competente = competente;
        this.asteptareSalariala = asteptareSalariala;
        this.deschisLaInterviu = deschisLaInterviu;
    }

    public String getNume() {
        return nume;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public List<String> getCompetente() {
        return competente;
    }

    public float getAsteptareSalariala() {
        return asteptareSalariala;
    }

    public boolean isDeschisLaInterviu() {
        return deschisLaInterviu;
    }
}

package ro.ase.csie.cts.tests.test6.sub1_adapter.models;

import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatExtern;
import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatPlatforma;

public class AdapterCandidatExternCandidatPlatforma implements AbstractCandidatPlatforma{
    private final AbstractCandidatExtern candidat;

    public AdapterCandidatExternCandidatPlatforma(AbstractCandidatExtern candidat) {
        this.candidat = candidat;
    }

    @Override
    public String obtineNume() {
        return candidat.numeComplet();
    }

    @Override
    public int obtineAniExperienta() {
        return candidat.totalAniExperienta();
    }

    @Override
    public String[] obtineCompetente() {
        return candidat.listaCompetente();
    }
}

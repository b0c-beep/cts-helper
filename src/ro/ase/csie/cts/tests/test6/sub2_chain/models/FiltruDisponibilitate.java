package ro.ase.csie.cts.tests.test6.sub2_chain.models;

import ro.ase.csie.cts.tests.test6.sub2_chain.abstracts.AbstractFiltruCandidat;

public class FiltruDisponibilitate extends AbstractFiltruCandidat {
    @Override
    public boolean proceseaza(Candidat candidat) {
        if (!candidat.isDeschisLaInterviu()) {
            System.out.println("CANDIDAT RESPINS DEOARECE REFUZA INTERVIU");
            return false;
        }
        else {
            if (urmator != null) {
                return urmator.proceseaza(candidat);
            }
            return true;
        }
    }
}

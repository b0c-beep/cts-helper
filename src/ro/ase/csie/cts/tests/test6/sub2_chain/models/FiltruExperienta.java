package ro.ase.csie.cts.tests.test6.sub2_chain.models;

import ro.ase.csie.cts.tests.test6.sub2_chain.abstracts.AbstractFiltruCandidat;

public class FiltruExperienta extends AbstractFiltruCandidat {
    private int experientaMinima;

    public FiltruExperienta(int experientaMinima) {
        this.experientaMinima = experientaMinima;
    }

    @Override
    public boolean proceseaza(Candidat candidat) {
        if (candidat.getAniExperienta() < experientaMinima) {
            System.out.println("CANDIDAT REFUZAT DIN CAUZA LIPSEI DE EXPERIENTA");
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

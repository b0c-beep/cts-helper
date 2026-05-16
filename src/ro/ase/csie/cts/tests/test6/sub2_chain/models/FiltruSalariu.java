package ro.ase.csie.cts.tests.test6.sub2_chain.models;

import ro.ase.csie.cts.tests.test6.sub2_chain.abstracts.AbstractFiltruCandidat;

public class FiltruSalariu extends AbstractFiltruCandidat {
    private float bugetSalariu;

    public FiltruSalariu(float bugetSalariu) {
        this.bugetSalariu = bugetSalariu;
    }

    @Override
    public boolean proceseaza(Candidat candidat) {
        if (candidat.getAsteptareSalariala() > bugetSalariu) {
            System.out.println("CANDIDAT REFUZAT DATORITA LIPSEI DE COMPATIBILITATE SALARIALA");
            return false;
        }
        else {
            if (urmator != null ){
                return urmator.proceseaza(candidat);
            }
            return true;
        }
    }
}

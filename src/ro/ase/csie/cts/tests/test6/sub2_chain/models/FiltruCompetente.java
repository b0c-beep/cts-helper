package ro.ase.csie.cts.tests.test6.sub2_chain.models;

import ro.ase.csie.cts.tests.test6.sub2_chain.abstracts.AbstractFiltruCandidat;

import java.util.ArrayList;
import java.util.List;

public class FiltruCompetente extends AbstractFiltruCandidat {
    private List<String> competenteObligatorii = new ArrayList<>();

    public FiltruCompetente(List<String> competenteObligatorii) {
        this.competenteObligatorii = competenteObligatorii;
    }

    @Override
    public boolean proceseaza(Candidat candidat) {
        if (!candidat.getCompetente().containsAll(competenteObligatorii)) {
            System.out.println("CANDIDAT REFUZAT DATORITA LIPSEI DE COMPETENTE OBLIGATORII");
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

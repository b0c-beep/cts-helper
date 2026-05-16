package ro.ase.csie.cts.tests.test6.sub2_chain.abstracts;

import ro.ase.csie.cts.tests.test6.sub2_chain.models.Candidat;

public abstract class AbstractFiltruCandidat {
    protected AbstractFiltruCandidat urmator;

    public void seteazaUrmator(AbstractFiltruCandidat urmator) { this.urmator = urmator; }

    public abstract boolean proceseaza(Candidat candidat);
}

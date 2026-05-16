package ro.ase.csie.cts.tests.test6.sub2_chain;

import ro.ase.csie.cts.tests.test6.sub2_chain.abstracts.AbstractFiltruCandidat;
import ro.ase.csie.cts.tests.test6.sub2_chain.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Candidat c1 = new Candidat("john", 10, List.of("c1", "c2", "c3", "c4"), 10000.0f, true);
        Candidat c2 = new Candidat("maria", 3, List.of("c1", "c2"), 4000.0f, true);

        AbstractFiltruCandidat exp = new FiltruExperienta(5);
        AbstractFiltruCandidat comp = new FiltruCompetente(List.of("c1", "c2", "c3"));
        AbstractFiltruCandidat interviu = new FiltruDisponibilitate();
        AbstractFiltruCandidat salariu = new FiltruSalariu(6500.0f);

        salariu.seteazaUrmator(exp);
        exp.seteazaUrmator(interviu);
        interviu.seteazaUrmator(comp);

        salariu.proceseaza(c1);
        salariu.proceseaza(c2);
    }
}

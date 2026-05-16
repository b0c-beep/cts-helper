package ro.ase.csie.cts.tests.test6.sub1_adapter;

import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatExtern;
import ro.ase.csie.cts.tests.test6.sub1_adapter.abstracts.AbstractCandidatPlatforma;
import ro.ase.csie.cts.tests.test6.sub1_adapter.models.AdapterCandidatExternCandidatPlatforma;
import ro.ase.csie.cts.tests.test6.sub1_adapter.models.CandidatExtern;
import ro.ase.csie.cts.tests.test6.sub1_adapter.models.CandidatPlatforma;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AbstractCandidatPlatforma c1 = new CandidatPlatforma("john", 13, new String[]{"comp1", "comp2", "comp3"});
        AbstractCandidatExtern c2 = new CandidatExtern("ion", new String[]{"c1", "c2", "c3"}, 10);

        System.out.println(c1.obtineNume());
        System.out.println(c1.obtineAniExperienta());
        System.out.println(Arrays.toString(c1.obtineCompetente()));
        System.out.println();

        System.out.println(c2.numeComplet());
        System.out.println(c2.totalAniExperienta());
        System.out.println(Arrays.toString(c2.listaCompetente()));
        System.out.println();

        c1 = new AdapterCandidatExternCandidatPlatforma(c2);
        System.out.println(c1.obtineNume());
        System.out.println(Arrays.toString(c1.obtineCompetente()));
        System.out.println(c1.obtineAniExperienta());

    }
}

package ro.ase.csie.cts.tests.test7.sub1_strategy.models;

import ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts.AbstractAlgoritmRuta;

public class AlgoritmTimpMinim implements AbstractAlgoritmRuta {

    @Override
    public Ruta calculeazaRuta(ReteaTransport retea, String statieStart, String statieFinal) {
        System.out.println("RUTA TIMP MINIM PE " + retea.getOras() + " de la " + statieStart + " la " + statieFinal);
        return new Ruta("Ruta rapida", 15, 8, 5.0);
    }
}

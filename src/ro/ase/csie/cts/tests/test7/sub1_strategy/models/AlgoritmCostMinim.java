package ro.ase.csie.cts.tests.test7.sub1_strategy.models;

import ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts.AbstractAlgoritmRuta;

public class AlgoritmCostMinim implements AbstractAlgoritmRuta {

    @Override
    public Ruta calculeazaRuta(ReteaTransport retea, String statieStart, String statieFinal) {
        System.out.println("RUTA COST MINIM PE " + retea.getOras() + " de la " + statieStart + " la " + statieFinal);
        return new Ruta("Ruta economie", 50, 12, 1.5);
    }
}

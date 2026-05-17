package ro.ase.csie.cts.tests.test7.sub1_strategy.models;

import ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts.AbstractAlgoritmRuta;

public class AlgoritmStatiiPutine implements AbstractAlgoritmRuta {
    @Override
    public Ruta calculeazaRuta(ReteaTransport retea, String statieStart, String statieFinal) {
        System.out.println("RUTA STATII PUTINE PE " + retea.getOras() + " de la " + statieStart + " la " + statieFinal);
        return new Ruta("Ruta directa", 35, 5, 3.5);
    }
}

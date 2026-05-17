package ro.ase.csie.cts.tests.test7.sub1_strategy.models;

import ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts.AbstractAlgoritmRuta;

public class AplicatieTransport {
    private AbstractAlgoritmRuta algoritm;

    public void setAlgoritm(AbstractAlgoritmRuta algoritm) { this.algoritm = algoritm; }

    public Ruta obtineRutaOptima(ReteaTransport retea, String start, String finish) {
        if (algoritm != null) {
            return algoritm.calculeazaRuta(retea, start, finish);
        } else {
            throw new UnsupportedOperationException("Niciun algoritm setat");
        }
    }
}

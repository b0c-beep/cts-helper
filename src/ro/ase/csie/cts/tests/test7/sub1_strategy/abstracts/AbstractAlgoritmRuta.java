package ro.ase.csie.cts.tests.test7.sub1_strategy.abstracts;

import ro.ase.csie.cts.tests.test7.sub1_strategy.models.ReteaTransport;
import ro.ase.csie.cts.tests.test7.sub1_strategy.models.Ruta;

public interface AbstractAlgoritmRuta {
    Ruta calculeazaRuta(ReteaTransport retea, String statieStart, String statieFinal);
}

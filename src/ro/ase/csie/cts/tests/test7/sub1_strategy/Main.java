package ro.ase.csie.cts.tests.test7.sub1_strategy;

import ro.ase.csie.cts.tests.test7.sub1_strategy.models.*;

public class Main {
    public static void main(String[] args) {
        ReteaTransport reteaBuc = new ReteaTransport("Bucuresti");

        AplicatieTransport app = new AplicatieTransport();

        String start = "Unirii";
        String finish = "Pantelimon";

        app.setAlgoritm(new AlgoritmTimpMinim());
        System.out.println(app.obtineRutaOptima(reteaBuc, start, finish));
        System.out.println();

        app.setAlgoritm(new AlgoritmStatiiPutine());
        System.out.println(app.obtineRutaOptima(reteaBuc, start, finish));
        System.out.println();

        app.setAlgoritm(new AlgoritmCostMinim());
        System.out.println(app.obtineRutaOptima(reteaBuc, start, finish));
        System.out.println();
    }
}

package ro.ase.csie.cts.tests.test4.sub1_composite;

import ro.ase.csie.cts.tests.test4.sub1_composite.abstracts.ICode;
import ro.ase.csie.cts.tests.test4.sub1_composite.models.NodClasa;
import ro.ase.csie.cts.tests.test4.sub1_composite.models.NodFunctie;

public class Main {
    public static void main(String[] args) {
        NodFunctie f1 = new NodFunctie("functie1", 3);
        NodFunctie f2 = new NodFunctie("functie2", 5);
        NodFunctie f3 = new NodFunctie("functie3", 2);

        NodClasa c1 = new NodClasa("clasa1");
        NodClasa c2 = new NodClasa("clasa2");
        NodClasa c3 = new NodClasa("clasa3");

        c1.adaugaCopil(f1);
        c1.adaugaCopil(c2);
        c1.adaugaCopil(c3);
        c2.adaugaCopil(f2);
        c3.adaugaCopil(f3);

        System.out.println("APELURI UNSAFE IN " + c1.getNumeClasa() + ": " + c1.obtineNumarApeluriUnsafe());
        System.out.println("APELURI UNSAFE IN " + c2.getNumeClasa() + ": " + c2.obtineNumarApeluriUnsafe());
        System.out.println("APELURI UNSAFE IN " + c3.getNumeClasa() + ": " + c3.obtineNumarApeluriUnsafe());
        System.out.println("APELURI UNSAFE IN " + f1.getNumeFunctie() + ": " + f1.obtineNumarApeluriUnsafe());
    }
}

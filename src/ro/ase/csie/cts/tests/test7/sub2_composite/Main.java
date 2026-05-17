package ro.ase.csie.cts.tests.test7.sub2_composite;

import ro.ase.csie.cts.tests.test7.sub2_composite.abstracts.AbstractElementTransport;
import ro.ase.csie.cts.tests.test7.sub2_composite.models.NodStatie;
import ro.ase.csie.cts.tests.test7.sub2_composite.models.NodTransport;

public class Main {
    public static void main(String[] args) {
        AbstractElementTransport statie1 = new NodStatie("Eroilor", 5000);
        AbstractElementTransport statie2 = new NodStatie("Izvor", 3000);
        AbstractElementTransport statie3 = new NodStatie("Unirii 1", 10000);
        AbstractElementTransport statie4 = new NodStatie("Unirii 2", 12000);

        // 2. Agregarea lor in noduri de transport
        NodTransport nodMagistrala1 = new NodTransport("Magistrala 1 Mici");
        nodMagistrala1.adaugaNod(statie1);
        nodMagistrala1.adaugaNod(statie2);

        NodTransport nodPiataUnirii = new NodTransport("Nod Piata Unirii");
        nodPiataUnirii.adaugaNod(statie3);
        nodPiataUnirii.adaugaNod(statie4);

        // Cream un nod complex care contine alte noduri
        NodTransport reteaCentrala = new NodTransport("Retea Centrala Bucuresti");
        reteaCentrala.adaugaNod(nodMagistrala1);
        reteaCentrala.adaugaNod(nodPiataUnirii);

        // 3. Calcularea numarului total de pasageri (apeleaza recursiv in tot arborele)
        System.out.println("Total pasageri M1 Mici: " + nodMagistrala1.calculeazaNumarPasageri());
        System.out.println("Total pasageri Retea Centrala: " + reteaCentrala.calculeazaNumarPasageri());

        // 4. Verificarea capacitatii pentru un nod complex
        int capacitateMaxAdmisa = 25000;
        boolean esteInCapacitate = reteaCentrala.verificaCapacitate(capacitateMaxAdmisa);

        System.out.println("Respecta rețeaua centrală capacitatea de " + capacitateMaxAdmisa + "? : " + esteInCapacitate);
    }
}

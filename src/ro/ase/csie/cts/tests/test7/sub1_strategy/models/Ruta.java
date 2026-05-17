package ro.ase.csie.cts.tests.test7.sub1_strategy.models;

public class Ruta {
    private String numeRuta;
    private int timpMinute;
    private int numarStatii;
    private double costBilet;

    public Ruta(String numeRuta, int timpMinute, int numarStatii, double costBilet) {
        this.numeRuta = numeRuta;
        this.timpMinute = timpMinute;
        this.numarStatii = numarStatii;
        this.costBilet = costBilet;
    }

    @Override
    public String toString() {
        return "Ruta [" + numeRuta + "] -> Timp: " + timpMinute + " min | Statii: " + numarStatii + " | Cost: " + costBilet + " RON";
    }
}

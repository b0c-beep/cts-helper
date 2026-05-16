package ro.ase.csie.cts.tests.test1.sub2_composite;

import ro.ase.csie.cts.tests.test1.sub2_composite.abstracts.IMedicalNode;
import ro.ase.csie.cts.tests.test1.sub2_composite.models.ContinentNode;
import ro.ase.csie.cts.tests.test1.sub2_composite.models.CountryNode;
import ro.ase.csie.cts.tests.test1.sub2_composite.models.VirusNode;

public class Main {
    public static void main(String[] args) {
        IMedicalNode europe = new ContinentNode("Europe");
        IMedicalNode germany = new CountryNode("Germany");
        IMedicalNode france = new CountryNode("France");
        IMedicalNode poland = new CountryNode("Poland");
        europe.addNode(germany);
        europe.addNode(poland);
        europe.addNode(france);

        germany.addNode(new VirusNode(20900, "german virus", "big scary virus"));
        germany.addNode(new VirusNode(5320, "flu", "usual flu"));

        france.addNode(new VirusNode(10300, "baguette virus", "virus found in baguettes"));
        france.addNode(new VirusNode(2400, "work virus", "virus aquired from work"));
        france.addNode(new VirusNode(5790, "eiffel virus", "virus aquired by visiting eiffel tower"));

        poland.addNode(new VirusNode(9710, "eastern virus", "virus from the east"));

        System.out.println("TOTAL CASES EUROPE: " + europe.getTotalCases());
        System.out.println("TOTAL CASES GERMANY: " + germany.getTotalCases());
        System.out.println("TOTAL CASES FRANCE: " + france.getTotalCases());
        System.out.println("TOTAL CASES POLAND: " + poland.getTotalCases());
    }
}

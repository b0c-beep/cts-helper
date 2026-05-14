package ro.ase.csie.cts.strategy;

import ro.ase.csie.cts.strategy.models.DataAnalysis;
import ro.ase.csie.cts.strategy.models.MaximumAnalysis;
import ro.ase.csie.cts.strategy.models.MeanAnalysis;

public class Main {
    public static void main(String[] args) {
        DataAnalysis analyzer = new DataAnalysis();
        analyzer.setAnalysisStrategy(new MaximumAnalysis());
        try {
            System.out.println(analyzer.getAnalysis(2.1, 1.8, 4.5, 2.7));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        analyzer.setAnalysisStrategy(new MeanAnalysis());
        try {
            System.out.println(analyzer.getAnalysis(9.5, 2.4, 10.4, 15.3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

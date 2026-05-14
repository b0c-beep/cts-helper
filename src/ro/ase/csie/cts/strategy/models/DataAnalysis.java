package ro.ase.csie.cts.strategy.models;

import ro.ase.csie.cts.strategy.abstracts.IAnalysisStrategy;

import java.util.List;

public class DataAnalysis {
    private IAnalysisStrategy strategy;

    public void setAnalysisStrategy(IAnalysisStrategy strategy) {
        this.strategy = strategy;
    }

    public double getAnalysis(Double... values) throws Exception {
        if(strategy != null) {
            return strategy.executeAnalysis(List.of(values));
        }
        else {
            throw new Exception("Sorry, no analysis strategy selected");
        }
    }
}

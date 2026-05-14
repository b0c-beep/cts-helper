package ro.ase.csie.cts.strategy.models;

import ro.ase.csie.cts.strategy.abstracts.IAnalysisStrategy;

import java.util.List;

public class MaximumAnalysis implements IAnalysisStrategy {
    @Override
    public double executeAnalysis(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
    }
}

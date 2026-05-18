package ro.ase.csie.cts.tests.test8.sub1_decorator.models;

import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.AMedicalFileDecorator;
import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.IMedicalFile;

public class MedicalFileWithLabs extends AMedicalFileDecorator {
    private String labsResults;
    private static final double LABS_FEE = 20.9f;

    public MedicalFileWithLabs(IMedicalFile decoratedFile, String labsResults) {
        super(decoratedFile);
        this.labsResults = labsResults;
    }

    @Override
    public String generateDescription() {
        StringBuilder sb = new StringBuilder(super.generateDescription());
        sb.append("LAB RESULTS: " + labsResults + "\n");
        return sb.toString();
    }

    @Override
    public double calculateProcessingCost() {
        return super.calculateProcessingCost() + LABS_FEE;
    }
}

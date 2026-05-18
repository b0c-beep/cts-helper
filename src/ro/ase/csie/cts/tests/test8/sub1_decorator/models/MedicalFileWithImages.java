package ro.ase.csie.cts.tests.test8.sub1_decorator.models;

import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.AMedicalFileDecorator;
import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.IMedicalFile;

public class MedicalFileWithImages extends AMedicalFileDecorator {
    private int numberOfImages;
    private static final double FEE_PER_IMAGE = 3.5f;

    public MedicalFileWithImages(IMedicalFile decoratedFile, int images) {
        super(decoratedFile);
        this.numberOfImages = images;
    }

    @Override
    public String generateDescription() {
        StringBuilder sb = new StringBuilder(super.generateDescription());
        sb.append("IMAGES TAKEN FOR DIAGNOSTIC: " + numberOfImages + "\n");
        return sb.toString();
    }

    @Override
    public double calculateProcessingCost() {
        return super.calculateProcessingCost() + (numberOfImages * FEE_PER_IMAGE);
    }
}

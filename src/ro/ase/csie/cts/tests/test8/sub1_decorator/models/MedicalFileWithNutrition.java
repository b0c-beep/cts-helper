package ro.ase.csie.cts.tests.test8.sub1_decorator.models;

import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.AMedicalFileDecorator;
import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.IMedicalFile;

public class MedicalFileWithNutrition extends AMedicalFileDecorator {
    private int nutritionPlanPhases;
    private static final double NUTRITION_PLAN_FEE = 24.0f;

    public MedicalFileWithNutrition(IMedicalFile decoratedFile, int phases) {
        super(decoratedFile);
        this.nutritionPlanPhases = phases;
    }

    @Override
    public String generateDescription() {
        StringBuilder sb = new StringBuilder(super.generateDescription());
        sb.append("NUTRITION PLAN WITH " + nutritionPlanPhases + " PHASES\n");
        return sb.toString();
    }

    @Override
    public double calculateProcessingCost() {
        return super.calculateProcessingCost() + NUTRITION_PLAN_FEE;
    }
}

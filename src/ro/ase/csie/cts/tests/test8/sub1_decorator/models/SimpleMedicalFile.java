package ro.ase.csie.cts.tests.test8.sub1_decorator.models;

import ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts.IMedicalFile;

import java.util.ArrayList;
import java.util.List;

public class SimpleMedicalFile implements IMedicalFile {
    private String diagnostic;
    private List<String> treatment = new ArrayList<>();
    private String recommendations;
    private static final double COST_PER_TREATMENT = 5.2f;

    public SimpleMedicalFile(String diagnostic, List<String> treatment, String recommendations) {
        this.diagnostic = diagnostic;
        this.treatment = treatment;
        this.recommendations = recommendations;
    }

    @Override
    public String generateDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("MEDICAL FILE\n");
        sb.append("TREATMENT:\n");
        treatment.forEach(t -> {sb.append(t); sb.append("\n");});
        sb.append("RECOMMENDATIONS: " + recommendations + "\n");
        return sb.toString();
    }

    @Override
    public double calculateProcessingCost() {
        return COST_PER_TREATMENT * treatment.size();
    }
}

package ro.ase.csie.cts.tests.test8.sub1_decorator;

import ro.ase.csie.cts.tests.test8.sub1_decorator.models.MedicalFileWithImages;
import ro.ase.csie.cts.tests.test8.sub1_decorator.models.MedicalFileWithLabs;
import ro.ase.csie.cts.tests.test8.sub1_decorator.models.MedicalFileWithNutrition;
import ro.ase.csie.cts.tests.test8.sub1_decorator.models.SimpleMedicalFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleMedicalFile file = new SimpleMedicalFile("java's disease", List.of("debugging pills", "clean code cardio"), "pay more attention");

        System.out.println(file.generateDescription());
        System.out.println(file.calculateProcessingCost());
        System.out.println();

        MedicalFileWithImages file2 = new MedicalFileWithImages(file, 3);

        System.out.println(file2.generateDescription());
        System.out.println(file2.calculateProcessingCost());
        System.out.println();

        MedicalFileWithLabs file3 = new MedicalFileWithLabs(file2, "labs are inconclusive");

        System.out.println(file3.generateDescription());
        System.out.println(file3.calculateProcessingCost());
        System.out.println();

        MedicalFileWithNutrition file4 = new MedicalFileWithNutrition(file3, 5);

        System.out.println(file4.generateDescription());
        System.out.println(file4.calculateProcessingCost());
        System.out.println();

    }
}

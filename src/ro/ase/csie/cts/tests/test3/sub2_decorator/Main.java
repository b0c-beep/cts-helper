package ro.ase.csie.cts.tests.test3.sub2_decorator;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;
import ro.ase.csie.cts.tests.test3.sub2_decorator.models.BrushwashOption;
import ro.ase.csie.cts.tests.test3.sub2_decorator.models.SimpleWash;

public class Main {
    public static void main(String[] args) {
        AbstractAutoWashOptions wash1 = new SimpleWash();
        System.out.println(wash1);
        AbstractAutoWashOptions wash2 = new BrushwashOption(wash1);
        System.out.println(wash2);

    }
}

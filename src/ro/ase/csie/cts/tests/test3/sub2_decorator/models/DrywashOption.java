package ro.ase.csie.cts.tests.test3.sub2_decorator.models;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;
import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractWashDecorator;

public class DrywashOption extends AbstractWashDecorator {

    public DrywashOption(AbstractAutoWashOptions wash) {
        super(wash);
    }

    @Override
    public boolean isDryingSelected() {
        return true;
    }
}

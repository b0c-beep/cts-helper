package ro.ase.csie.cts.tests.test3.sub2_decorator.models;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;
import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractWashDecorator;

public class PolishwashOption extends AbstractWashDecorator {

    public PolishwashOption(AbstractAutoWashOptions wash) {
        super(wash);
    }

    @Override
    public boolean isWaxAndPolishSelected() {
        return true;
    }
}

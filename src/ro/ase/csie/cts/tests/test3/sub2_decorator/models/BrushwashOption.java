package ro.ase.csie.cts.tests.test3.sub2_decorator.models;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;
import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractWashDecorator;

public class BrushwashOption extends AbstractWashDecorator {

    public BrushwashOption(AbstractAutoWashOptions wash) {
        super(wash);
    }

    @Override
    public boolean isBrushWashingSelected() {
        return true;
    }
}

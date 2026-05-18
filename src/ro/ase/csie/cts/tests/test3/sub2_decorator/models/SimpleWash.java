package ro.ase.csie.cts.tests.test3.sub2_decorator.models;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;

public class SimpleWash implements AbstractAutoWashOptions {

    @Override
    public boolean isPrewashSelected() {
        return false;
    }

    @Override
    public boolean isBrushWashingSelected() {
        return false;
    }

    @Override
    public boolean isWaxAndPolishSelected() {
        return false;
    }

    @Override
    public boolean isDryingSelected() {
        return false;
    }
}

package ro.ase.csie.cts.tests.test3.sub2_decorator.models;

import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractAutoWashOptions;
import ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts.AbstractWashDecorator;

public class PrewashOption extends AbstractWashDecorator {

    public PrewashOption(AbstractAutoWashOptions wash) {
        super(wash);
    }

    @Override
    public boolean isPrewashSelected() {
        return true;
    }
}

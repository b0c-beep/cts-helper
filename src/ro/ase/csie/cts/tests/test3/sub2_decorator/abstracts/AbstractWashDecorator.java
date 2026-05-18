package ro.ase.csie.cts.tests.test3.sub2_decorator.abstracts;

public abstract class AbstractWashDecorator implements AbstractAutoWashOptions {
    private AbstractAutoWashOptions wash;

    public AbstractWashDecorator(AbstractAutoWashOptions wash) {
        this.wash = wash;
    }

    @Override
    public boolean isPrewashSelected() {
        return wash.isPrewashSelected();
    }

    @Override
    public boolean isBrushWashingSelected() {
        return wash.isBrushWashingSelected();
    }

    @Override
    public boolean isWaxAndPolishSelected() {
        return wash.isWaxAndPolishSelected();
    }

    @Override
    public boolean isDryingSelected() {
        return wash.isDryingSelected();
    }
}

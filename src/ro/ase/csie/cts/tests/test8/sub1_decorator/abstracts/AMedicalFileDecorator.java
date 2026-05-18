package ro.ase.csie.cts.tests.test8.sub1_decorator.abstracts;

public abstract class AMedicalFileDecorator implements IMedicalFile {
    private IMedicalFile decoratedFile;

    public AMedicalFileDecorator(IMedicalFile decoratedFile) {
        this.decoratedFile = decoratedFile;
    }

    @Override
    public String generateDescription() {
        return decoratedFile.generateDescription();
    }

    @Override
    public double calculateProcessingCost() {
        return decoratedFile.calculateProcessingCost();
    }
}

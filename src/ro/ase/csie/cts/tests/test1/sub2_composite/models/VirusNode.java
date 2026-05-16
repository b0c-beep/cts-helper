package ro.ase.csie.cts.tests.test1.sub2_composite.models;

import ro.ase.csie.cts.tests.test1.sub2_composite.abstracts.IMedicalNode;

import java.util.Collection;
import java.util.List;

public class VirusNode implements IMedicalNode {
    private int totalCases;
    private String virusName;
    private String virusDescription;

    public VirusNode(int totalCases, String virusName, String virusDescription) {
        this.totalCases = totalCases;
        this.virusName = virusName;
        this.virusDescription = virusDescription;
    }

    @Override
    public int getTotalCases() {
        return totalCases;
    }

    @Override
    public void addNode(IMedicalNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteNode(IMedicalNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<IMedicalNode> getNodes() {
        throw new UnsupportedOperationException();
    }
}

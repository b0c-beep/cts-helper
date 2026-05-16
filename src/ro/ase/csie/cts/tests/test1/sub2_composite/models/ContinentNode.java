package ro.ase.csie.cts.tests.test1.sub2_composite.models;

import ro.ase.csie.cts.tests.test1.sub2_composite.abstracts.IMedicalNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContinentNode implements IMedicalNode {
    private String name;
    private List<IMedicalNode> countries = new ArrayList<>();

    public ContinentNode(String name) {
        this.name = name;
    }

    @Override
    public int getTotalCases() {
        return countries.stream().mapToInt(IMedicalNode::getTotalCases).sum();
    }

    @Override
    public void addNode(IMedicalNode node) {
        countries.add(node);
    }

    @Override
    public void deleteNode(IMedicalNode node) {
        countries.remove(node);
    }

    @Override
    public Collection<IMedicalNode> getNodes() {
        return List.copyOf(countries);
    }
}

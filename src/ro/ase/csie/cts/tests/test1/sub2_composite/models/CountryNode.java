package ro.ase.csie.cts.tests.test1.sub2_composite.models;

import ro.ase.csie.cts.tests.test1.sub2_composite.abstracts.IMedicalNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CountryNode implements IMedicalNode {
    private String name;
    private List<IMedicalNode> viruses = new ArrayList<>();

    public CountryNode(String name) {
        this.name = name;
    }

    @Override
    public int getTotalCases() {
        return viruses.stream().mapToInt(IMedicalNode::getTotalCases).sum();
    }

    @Override
    public void addNode(IMedicalNode node) {
        viruses.add(node);
    }

    @Override
    public void deleteNode(IMedicalNode node) {
        viruses.add(node);
    }

    @Override
    public Collection<IMedicalNode> getNodes() {
        return List.copyOf(viruses);
    }
}

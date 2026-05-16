package ro.ase.csie.cts.tests.test1.sub2_composite.abstracts;

import java.util.Collection;

public interface IMedicalNode {
    int getTotalCases();

    void addNode(IMedicalNode node);

    void deleteNode(IMedicalNode node);

    Collection<IMedicalNode> getNodes();
}

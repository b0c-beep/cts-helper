package ro.ase.csie.cts.tests.test9.sub2_composite.models;

import ro.ase.csie.cts.tests.test9.sub1_proxy.abstracts.IDigitalDocument;
import ro.ase.csie.cts.tests.test9.sub2_composite.abstracts.ILibraryElement;

import java.util.ArrayList;
import java.util.List;

public class Category implements ILibraryElement {
    private String name;
    private List<ILibraryElement> children = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addElement(ILibraryElement element) {
        children.add(element);
    }

    public void removeElement(ILibraryElement element) {
        children.add(element);
    }

    public List<ILibraryElement> getChildren() {
        return List.copyOf(children);
    }

    @Override
    public int calculateNumberOfPages() {
        return children.stream().mapToInt(ILibraryElement::calculateNumberOfPages).sum();
    }

    @Override
    public boolean checkLimit(int maxLimit) {
        return calculateNumberOfPages() <= maxLimit;
    }
}

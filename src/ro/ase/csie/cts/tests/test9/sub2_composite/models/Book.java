package ro.ase.csie.cts.tests.test9.sub2_composite.models;

import ro.ase.csie.cts.tests.test9.sub2_composite.abstracts.ILibraryElement;

public class Book implements ILibraryElement {
    private String name;
    private String author;
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public int calculateNumberOfPages() {
        return pages;
    }

    @Override
    public boolean checkLimit(int maxLimit) {
        return pages <= maxLimit;
    }
}

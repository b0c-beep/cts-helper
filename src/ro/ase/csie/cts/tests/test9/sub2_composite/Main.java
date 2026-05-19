package ro.ase.csie.cts.tests.test9.sub2_composite;

import ro.ase.csie.cts.tests.test9.sub2_composite.abstracts.ILibraryElement;
import ro.ase.csie.cts.tests.test9.sub2_composite.models.Book;
import ro.ase.csie.cts.tests.test9.sub2_composite.models.Category;

public class Main {
    public static void main(String[] args) {
        ILibraryElement book1 = new Book("book1", "author1", 300);
        ILibraryElement book2 = new Book("book2", "author2", 450);
        ILibraryElement book3 = new Book("book3", "author3", 520);

        Category romance = new Category("romance");
        romance.addElement(book1);
        romance.addElement(book2);

        Category thriller = new Category("thriller");
        thriller.addElement(book3);

        Category library = new Category("root");
        library.addElement(romance);
        library.addElement(thriller);

        System.out.println("Library pages: " + library.calculateNumberOfPages());
        System.out.println("Library limit: " + 1200 + " -> " + library.checkLimit(1200));

        System.out.println("Romance category pages: " + romance.calculateNumberOfPages());
        System.out.println("Romance category limit: " + 500 + " -> " + library.checkLimit(500));
    }
}

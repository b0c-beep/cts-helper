package ro.ase.csie.cts.composite;

import ro.ase.csie.cts.composite.abstracts.IStoreItem;
import ro.ase.csie.cts.composite.models.StoreItem;
import ro.ase.csie.cts.composite.models.StorePackage;

public class Main {
    public static void main(String[] args) {
        IStoreItem package1 = new StorePackage("PACKAGE 1");
        IStoreItem it1 = new StoreItem("keyboard", 25.2f);
        IStoreItem it2 = new StoreItem("glass", 5.88f);
        IStoreItem it3 = new StoreItem("hatchet", 56.0f);

        package1.addItem(it1);
        package1.addItem(it2);

        it3.showDetails();

        System.out.println();
        package1.showDetails();
    }
}

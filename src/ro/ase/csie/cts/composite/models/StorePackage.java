package ro.ase.csie.cts.composite.models;

import ro.ase.csie.cts.composite.abstracts.IStoreItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StorePackage implements IStoreItem {
    private String packageName;
    List<IStoreItem> items = new ArrayList<>();

    public StorePackage(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void showDetails() {
        System.out.println("Package details: " + packageName);
        System.out.println("Contains: ");
        for (IStoreItem item : items) {
            item.showDetails();
        }
        System.out.println("End package");
    }

    @Override
    public float getPrice() {
        return (float) items.stream().mapToDouble(IStoreItem::getPrice).sum();
    }

    @Override
    public void addItem(IStoreItem item) {
        items.add(item);
    }

    @Override
    public void deleteItem(IStoreItem item) {
        items.remove(item);
    }

    @Override
    public Collection<IStoreItem> getItems() {
        return List.copyOf(items);
    }
}

package ro.ase.csie.cts.composite.models;

import ro.ase.csie.cts.composite.abstracts.IStoreItem;

import java.util.Collection;
import java.util.List;

public class StoreItem implements IStoreItem {
    private String name;
    private float price;

    public StoreItem(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showDetails() {
        System.out.println(name);
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void addItem(IStoreItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteItem(IStoreItem item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<IStoreItem> getItems() {
        throw new UnsupportedOperationException();
    }
}

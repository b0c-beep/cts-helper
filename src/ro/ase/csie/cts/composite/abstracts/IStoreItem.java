package ro.ase.csie.cts.composite.abstracts;

import java.util.Collection;

public interface IStoreItem {
    void showDetails();
    float getPrice();

    void addItem(IStoreItem item);

    void deleteItem(IStoreItem item);

    Collection<IStoreItem> getItems();
}

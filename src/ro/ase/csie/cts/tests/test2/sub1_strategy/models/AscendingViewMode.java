package ro.ase.csie.cts.tests.test2.sub1_strategy.models;

import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IProduct;
import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IViewMode;

import java.util.Comparator;
import java.util.List;

public class AscendingViewMode implements IViewMode {

    @Override
    public void showProducts(List<IProduct> products) {
        products.sort(Comparator.comparing(p -> ((Product)p).getPrice()));
        products.forEach(IProduct::showProduct);
    }
}

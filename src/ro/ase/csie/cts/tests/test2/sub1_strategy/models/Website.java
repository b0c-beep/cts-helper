package ro.ase.csie.cts.tests.test2.sub1_strategy.models;

import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IProduct;
import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IViewMode;

import java.util.List;

public class Website {
    private IViewMode viewmode;

    public void setViewMode(IViewMode vm) {
        this.viewmode = vm;
    }

    public void getProducts(List<IProduct> products) throws Exception {
        if (viewmode != null) {
            viewmode.showProducts(products);
        }
        else throw new Exception("No viewmode selected");
    }
}

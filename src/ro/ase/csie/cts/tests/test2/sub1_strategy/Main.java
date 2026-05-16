package ro.ase.csie.cts.tests.test2.sub1_strategy;

import ro.ase.csie.cts.tests.test2.sub1_strategy.abstracts.IProduct;
import ro.ase.csie.cts.tests.test2.sub1_strategy.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Website site = new Website();
        IProduct prod1 = new Product("remote", 20.4f, 100);
        IProduct prod2 = new Product("tv", 1200.4f, 40);
        IProduct prod3 = new Product("banana", 2.3f, 60);
        List<IProduct> prods = new ArrayList<>();
        prods.add(prod1);
        prods.add(prod2);
        prods.add(prod3);

        site.setViewMode(new AscendingViewMode());
        try {
            site.getProducts(prods);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println();

        site.setViewMode(new DescendingViewMode());
        try {
            site.getProducts(prods);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println();

        site.setViewMode(new ReviewsViewMode());
        try {
            site.getProducts(prods);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println();
    }
}

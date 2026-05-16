package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.AWebsiteHandler;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class ImageFilter extends AWebsiteHandler {
    @Override
    public void filter(Website site) {
        if(site.getItems().stream().anyMatch(i -> i.getType().equals(WebType.IMAGE))) {
            System.out.println("FILTERED OUT IMAGES");
            site.getItems().removeIf(i -> i.getType().equals(WebType.IMAGE));
        }
        if(next != null) {
            next.filter(site);
        }
    }
}

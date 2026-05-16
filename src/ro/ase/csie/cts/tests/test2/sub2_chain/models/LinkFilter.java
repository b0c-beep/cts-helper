package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.AWebsiteHandler;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class LinkFilter extends AWebsiteHandler {
    @Override
    public void filter(Website site) {
        if (site.getItems().stream().anyMatch(i -> i.getType().equals(WebType.LINK))) {
            System.out.println("DISABLED LINKS");
            site.getItems().stream().filter(i -> i.getType().equals(WebType.LINK)).forEach(i -> ((WebLink)i).setAddress(""));
        }
        if(next != null) {
            next.filter(site);
        }
    }
}

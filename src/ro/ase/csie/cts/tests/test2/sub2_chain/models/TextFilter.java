package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.AWebsiteHandler;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class TextFilter extends AWebsiteHandler {
    @Override
    public void filter(Website site) {
        if (site.getItems().stream().filter(i -> i.getType().equals(WebType.TEXT)).anyMatch(t -> !((WebText)t).getColor().equalsIgnoreCase("black"))) {
            System.out.println("CHANGED ALL TEXT ITEMS COLOR TO BLACK");
            site.getItems().stream().filter(i -> i.getType().equals(WebType.TEXT)).forEach(t -> ((WebText)t).setColor("black"));
        }
        if(next != null ) {
            next.filter(site);
        }
    }
}

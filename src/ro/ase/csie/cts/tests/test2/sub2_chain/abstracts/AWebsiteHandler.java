package ro.ase.csie.cts.tests.test2.sub2_chain.abstracts;

import ro.ase.csie.cts.tests.test2.sub2_chain.models.Website;

public abstract class AWebsiteHandler {
    protected AWebsiteHandler next;

    public void setNextHandler(AWebsiteHandler handler) { this.next = handler; }

    public abstract void filter(Website site);
}

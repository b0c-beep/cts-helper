package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.IWebItem;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class WebLink implements IWebItem {
    private final WebType type = WebType.LINK;
    private String address;

    public WebLink(String address) {
        this.address = address;
    }

    @Override
    public WebType getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void getItemDesc() {
        System.out.println("WEB LINK");
        System.out.println("ADDRESS: " + address);
        System.out.println();
    }
}

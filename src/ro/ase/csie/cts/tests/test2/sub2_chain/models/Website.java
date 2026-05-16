package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.IWebItem;

import java.util.ArrayList;
import java.util.List;

public class Website {
    private List<IWebItem> items = new ArrayList<>();
    private String domain;

    public Website(String domain) {
        this.domain = domain;
    }

    public void addItem(IWebItem item) {
        items.add(item);
    }

    public void deleteItem(IWebItem item) {
        items.add(item);
    }

    public String getDomain() {
        return domain;
    }

    public void showSite() {
        items.forEach(IWebItem::getItemDesc);
    }

    public List<IWebItem> getItems() {
        return items;
    }
}

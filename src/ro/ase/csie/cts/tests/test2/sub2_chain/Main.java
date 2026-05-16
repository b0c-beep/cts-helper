package ro.ase.csie.cts.tests.test2.sub2_chain;

import ro.ase.csie.cts.chain.abstracts.ADeliveryHandler;
import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.AWebsiteHandler;
import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.IWebItem;
import ro.ase.csie.cts.tests.test2.sub2_chain.models.*;

public class Main {
    public static void main(String[] args) {
        Website website = new Website("ase.ro");
        IWebItem i1 = new WebImage("img1.png", 100, 100);
        IWebItem i2 = new WebLink("http://sdadsad.com");
        IWebItem i3 = new WebText("dummy text", "RED", 32);
        IWebItem i4 = new WebText("test test test text", "GREEN", 24);
        IWebItem i5 = new WebText("hello this is text", "black", 12);
        IWebItem i6 = new WebImage("testimage.jpg", 250, 400);
        IWebItem i7 = new WebLink("https://google.com");
        website.addItem(i1);
        website.addItem(i2);
        website.addItem(i3);
        website.addItem(i4);
        website.addItem(i5);
        website.addItem(i6);
        website.addItem(i7);

        AWebsiteHandler tf = new TextFilter();
        AWebsiteHandler lf = new LinkFilter();
        AWebsiteHandler ifl = new ImageFilter();

        lf.setNextHandler(tf);
        tf.setNextHandler(ifl);

        lf.filter(website);
        website.showSite();

    }
}

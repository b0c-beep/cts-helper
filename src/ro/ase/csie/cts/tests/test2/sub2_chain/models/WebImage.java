package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.IWebItem;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class WebImage implements IWebItem {
    private final WebType type = WebType.IMAGE;
    private String imageName;
    private int width;
    private int height;

    public WebImage(String imageName, int width, int height) {
        this.imageName = imageName;
        this.width = width;
        this.height = height;
    }

    public String getImageName() {
        return imageName;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void getItemDesc() {
        System.out.println("WEB IMAGE");
        System.out.println("NAME: " + imageName);
        System.out.println("WIDTH: " + width);
        System.out.println("HEIGHT: " + height);
        System.out.println();
    }

    @Override
    public WebType getType() {
        return type;
    }
}

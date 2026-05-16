package ro.ase.csie.cts.tests.test2.sub2_chain.models;

import ro.ase.csie.cts.tests.test2.sub2_chain.abstracts.IWebItem;
import ro.ase.csie.cts.tests.test2.sub2_chain.enums.WebType;

public class WebText implements IWebItem {
    private final WebType type = WebType.TEXT;
    private String text;
    private String color;
    private int font;

    public WebText(String text, String color, int font) {
        this.text = text;
        this.color = color;
        this.font = font;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFont() {
        return font;
    }

    @Override
    public void getItemDesc() {
        System.out.println("WEB TEXT");
        System.out.println("TEXT: " + text);
        System.out.println("COLOR: " + color);
        System.out.println("FONT: " + font);
        System.out.println();
    }

    @Override
    public WebType getType() {
        return type;
    }
}

package ro.ase.csie.cts.tests.test9.sub1_proxy.models;

import ro.ase.csie.cts.tests.test9.sub1_proxy.abstracts.IDigitalDocument;

public class DigitalDocument implements IDigitalDocument {
    private String title;
    private String content;
    private String author;
    private String code;

    public DigitalDocument(String title, String content, String author, String code) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.code = code;
    }

    @Override
    public void showDocument(String user) {
        System.out.println(title);
        System.out.println(author);
        System.out.println();
        System.out.println(content);
        System.out.println();
    }

    @Override
    public String getCode() {
        return code;
    }


}

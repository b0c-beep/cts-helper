package ro.ase.csie.cts.tests.test9.sub1_proxy;

import ro.ase.csie.cts.tests.test9.sub1_proxy.abstracts.IDigitalDocument;
import ro.ase.csie.cts.tests.test9.sub1_proxy.models.AuthorizedDocumentProxy;
import ro.ase.csie.cts.tests.test9.sub1_proxy.models.DigitalDocument;

public class Main {
    public static void main(String[] args) {
        IDigitalDocument d1 = new DigitalDocument("doc1", "content....sdadsasdad", "author_doc1", "abc1");
        IDigitalDocument d2 = new DigitalDocument("doc2", "bla bla bla.....", "author_doc2", "defx");
        IDigitalDocument d3 = new DigitalDocument("doc1", "content....sdadsasdad", "author_doc1", "abc1");

        AuthorizedDocumentProxy p1 = new AuthorizedDocumentProxy(d1);
        AuthorizedDocumentProxy p2 = new AuthorizedDocumentProxy(d2);
        AuthorizedDocumentProxy p3 = new AuthorizedDocumentProxy(d3);

        p1.signUp("alice", "SUPER_SECRET_PASSWORD");
        p1.signUp("hacker", "admin");

        System.out.println();

        p1.showDocument("alice");
        p1.showDocument("hacker");
        p2.showDocument("alice");
    }
}

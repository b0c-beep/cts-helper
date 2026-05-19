package ro.ase.csie.cts.tests.test9.sub1_proxy.models;

import ro.ase.csie.cts.tests.test9.sub1_proxy.abstracts.IDigitalDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorizedDocumentProxy implements IDigitalDocument {
    private IDigitalDocument document;
    private static final String AUTHORIZATION_PASSWORD = "SUPER_SECRET_PASSWORD";
    private List<String> authorizedUsers = new ArrayList<>();
    private static Map<String, IDigitalDocument> cache = new HashMap<>();

    public AuthorizedDocumentProxy(IDigitalDocument document) {
        this.document = document;

        if(!cache.containsKey(document.getCode())) {
            cache.put(document.getCode(), document);
            System.out.println("DOCUMENT LOADED INTO CACHE: " + document.getCode());
        } else {
            System.out.println("DOCUMENT REUSED FROM CACHE: " + document.getCode());
        }
    }

    public void signUp(String user, String password) {
        if(AUTHORIZATION_PASSWORD.equals(password)) {
            authorizedUsers.add(user);
            System.out.println("USER AUTHORIZED");
        }
        else {
            System.out.println("ERROR! WRONG PASSWORD, AUTHORIZATION DENIED");
        }
    }

    @Override
    public void showDocument(String user) {
        if(authorizedUsers.contains(user)) {
            cache.get(document.getCode()).showDocument(user);
        }
        else {
            System.out.println("USER HAS NO AUTHORIZATION");
        }
    }

    @Override
    public String getCode() {
        return document.getCode();
    }
}

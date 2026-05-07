package ro.ase.csie.cts.proxy.models;

import ro.ase.csie.cts.proxy.abstracts.IInternetConnection;

import java.util.ArrayList;
import java.util.List;

public class InternetProxy implements IInternetConnection {
    private final IInternetConnection connecter;
    private List<String> forbiddenSites = new ArrayList<>();

    public InternetProxy(IInternetConnection connecter) {
        this.connecter = connecter;
        forbiddenSites.add("facebook.com");
        forbiddenSites.add("instagram.com");
        forbiddenSites.add("tiktok.com");
    }

    @Override
    public void connect(String host) {
        if (forbiddenSites.stream().anyMatch(h -> h.equalsIgnoreCase(host))) {
            throw new UnsupportedOperationException("Forbidden site, connection refused by proxy");
        }
        connecter.connect(host);
    }
}

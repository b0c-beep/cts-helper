package ro.ase.csie.cts.proxy.models;

import ro.ase.csie.cts.proxy.abstracts.IInternetConnection;

public class RealInternetConnection implements IInternetConnection {

    @Override
    public void connect(String host) {
        System.out.println("Successful connection to " + host);
    }
}

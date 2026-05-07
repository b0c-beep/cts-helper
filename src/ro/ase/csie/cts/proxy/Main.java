package ro.ase.csie.cts.proxy;

import ro.ase.csie.cts.proxy.abstracts.IInternetConnection;
import ro.ase.csie.cts.proxy.models.InternetProxy;
import ro.ase.csie.cts.proxy.models.RealInternetConnection;

public class Main {
    public static void main(String[] args) {
        IInternetConnection conn = new RealInternetConnection();
        conn.connect("ase.ro");
        conn.connect("google.com");
        conn.connect("instagram.com");

        conn = new InternetProxy(conn);
        conn.connect("instagram.com");
    }
}

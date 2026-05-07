package ro.ase.csie.cts.facade;

import ro.ase.csie.cts.facade.models.SmartHomeFacade;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade facade = new SmartHomeFacade();
        facade.leaveHome();
        System.out.println();
        facade.comeHome();
    }
}

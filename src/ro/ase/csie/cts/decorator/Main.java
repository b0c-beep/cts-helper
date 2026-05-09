package ro.ase.csie.cts.decorator;

import ro.ase.csie.cts.decorator.abstracts.ICharacter;
import ro.ase.csie.cts.decorator.models.ShieldEquipment;
import ro.ase.csie.cts.decorator.models.SwordEquipment;
import ro.ase.csie.cts.decorator.models.Warrior;

public class Main {
    public static void main(String[] args) {
        ICharacter c = new Warrior();

        c.attack();
        System.out.println();
        c.defend();
        System.out.println();

        System.out.println();
        SwordEquipment c2 = new SwordEquipment(c);
        c2.attack();
        System.out.println();
        c2.defend();
        System.out.println();


        System.out.println();
        ShieldEquipment c3 = new ShieldEquipment(c2);
        c3.attack();
        System.out.println();
        c3.defend();
        System.out.println();
    }
}

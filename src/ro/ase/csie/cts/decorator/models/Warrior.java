package ro.ase.csie.cts.decorator.models;

import ro.ase.csie.cts.decorator.abstracts.ICharacter;

public class Warrior implements ICharacter {

    @Override
    public void attack() {
        System.out.println("Warrior attacks with hands");
    }

    @Override
    public void defend() {
        System.out.print("Warrior defends with hands");
    }
}

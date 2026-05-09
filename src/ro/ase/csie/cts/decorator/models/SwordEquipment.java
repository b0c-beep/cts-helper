package ro.ase.csie.cts.decorator.models;

import ro.ase.csie.cts.decorator.abstracts.AEquipmentDecorator;
import ro.ase.csie.cts.decorator.abstracts.ICharacter;

public class SwordEquipment extends AEquipmentDecorator {
    public SwordEquipment(ICharacter character) {
        super(character);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.print("+ attack with sword");
    }
}

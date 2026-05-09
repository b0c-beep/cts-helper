package ro.ase.csie.cts.decorator.models;

import ro.ase.csie.cts.decorator.abstracts.AEquipmentDecorator;
import ro.ase.csie.cts.decorator.abstracts.ICharacter;

public class ShieldEquipment extends AEquipmentDecorator {

    public ShieldEquipment(ICharacter character) {
        super(character);
    }

    @Override
    public void defend() {
        super.defend();
        System.out.print("+ defend with shield");
    }
}

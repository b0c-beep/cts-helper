package ro.ase.csie.cts.decorator.abstracts;

public class AEquipmentDecorator implements ICharacter{
    private ICharacter character;

    public AEquipmentDecorator(ICharacter character) {
        this.character = character;
    }

    @Override
    public void attack() {
        character.attack();
    }

    @Override
    public void defend() {
        character.defend();
    }
}

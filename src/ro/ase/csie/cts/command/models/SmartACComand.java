package ro.ase.csie.cts.command.models;

import ro.ase.csie.cts.command.abstracts.ISmartCommand;

public class SmartACComand implements ISmartCommand {
    private SmartSystem system;

    public SmartACComand(SmartSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        system.startUpAC();
    }
}

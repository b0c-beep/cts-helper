package ro.ase.csie.cts.command.models;

import ro.ase.csie.cts.command.abstracts.ISmartCommand;

public class SmartLightsCommand implements ISmartCommand {
    private SmartSystem system;

    public SmartLightsCommand(SmartSystem system) {
        this.system = system;
    }

    @Override
    public void execute() {
        system.turnOnLights();
    }
}

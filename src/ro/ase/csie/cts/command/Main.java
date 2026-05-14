package ro.ase.csie.cts.command;

import ro.ase.csie.cts.command.abstracts.ISmartCommand;
import ro.ase.csie.cts.command.models.SmartACComand;
import ro.ase.csie.cts.command.models.SmartLightsCommand;
import ro.ase.csie.cts.command.models.SmartSystem;
import ro.ase.csie.cts.command.models.VocalAssistant;

public class Main {
    public static void main(String[] args) {
        SmartSystem system = new SmartSystem();
        VocalAssistant assistant = new VocalAssistant();

        ISmartCommand comm1 = new SmartLightsCommand(system);
        ISmartCommand comm2 = new SmartACComand(system);

        assistant.addCommand(comm1);
        assistant.addCommand(comm2);
        assistant.runCommands();
    }
}

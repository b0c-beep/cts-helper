package ro.ase.csie.cts.command.models;

import ro.ase.csie.cts.command.abstracts.ISmartCommand;

import java.util.ArrayList;
import java.util.List;

public class VocalAssistant {
    private List<ISmartCommand> commands = new ArrayList<>();

    public void addCommand(ISmartCommand command) {
        commands.add(command);
    }

    public void runCommands() {
        commands.forEach(ISmartCommand::execute);
        commands.clear();
    }
}

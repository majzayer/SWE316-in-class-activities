import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command {
    private final List<Command> commands;
    private final List<Command> executedCommands = new ArrayList<>();

    public MacroCommand(List<Command> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public boolean execute() {
        executedCommands.clear();
        for (Command command : commands) {
            if (command.execute()) {
                executedCommands.add(command);
            }
        }
        return !executedCommands.isEmpty();
    }

    @Override
    public void undo() {
        for (Command command : executedCommands) {
            command.undo();
        }
        executedCommands.clear();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MacroCommand implements Command {
    private final List<Command> commands;
    private final List<Command> executedCommands = new ArrayList<>();

    public MacroCommand(Command... commands) {
        this.commands = new ArrayList<>(Arrays.asList(commands));
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
        for (int i = executedCommands.size() - 1; i >= 0; i--) {
            executedCommands.get(i).undo();
        }
        executedCommands.clear();
    }
}

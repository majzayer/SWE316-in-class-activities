import java.util.ArrayDeque;
import java.util.Deque;

public class CommandManager {
    private final Deque<Command> history = new ArrayDeque<>();

    public void execute(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.peek();
            command.undo();
            history.pop();
        }
    }
}

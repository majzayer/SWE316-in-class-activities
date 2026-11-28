public class Button {
    private final String label;
    private final CommandManager manager;
    private final Command command;

    public Button(String label, CommandManager manager, Command command) {
        this.label = label;
        this.manager = manager;
        this.command = command;
    }

    public void render() {
        System.out.println("Rendering button: " + label);
    }

    public void onClick() {
        manager.execute(command);
    }
}

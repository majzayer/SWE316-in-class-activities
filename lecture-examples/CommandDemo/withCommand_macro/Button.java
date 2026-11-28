public class Button {
    private final String label;
    private final CommandManager manager;

    public Button(String label, CommandManager manager) {
        this.label = label;
        this.manager = manager;
    }

    public void render() {
        System.out.println("Rendering button: " + label);
    }

    public void onClick(Command command) {
        manager.execute(command);
    }
}

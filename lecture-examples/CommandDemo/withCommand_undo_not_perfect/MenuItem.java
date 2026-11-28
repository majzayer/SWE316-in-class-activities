public class MenuItem {
    private final String label;
    private final CommandManager manager;
    private final Command command;

    public MenuItem(String label, CommandManager manager, Command command) {
        this.label = label;
        this.manager = manager;
        this.command = command;
    }

    public void render() {
        System.out.println("Rendering menu item: " + label);
    }

    public void onSelect() {
        manager.execute(command);
    }
}

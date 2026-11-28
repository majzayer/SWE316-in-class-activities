public class MenuItem {
    private final String label;
    private final CommandManager manager;

    public MenuItem(String label, CommandManager manager) {
        this.label = label;
        this.manager = manager;
    }

    public void render() {
        System.out.println("Rendering menu item: " + label);
    }

    public void onSelect(Command command) {
        manager.execute(command);
    }
}

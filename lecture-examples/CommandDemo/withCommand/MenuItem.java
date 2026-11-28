class MenuItem {
    private final String label;
    private final Command command;

    public MenuItem(String label, Command command) {
        this.label = label;
        this.command = command;
    }

    public void render() {
        System.out.println("Rendering menu item: " + label);
    }

    public void onSelect() {
        command.execute();
    }
}

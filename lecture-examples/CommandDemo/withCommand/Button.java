class Button {
    private final String label;
    private final Command command;

    public Button(String label, Command command) {
        this.label = label;
        this.command = command;
    }

    public void render() {
        System.out.println("Rendering button: " + label);
    }

    public void onClick() {
        command.execute();
    }
}

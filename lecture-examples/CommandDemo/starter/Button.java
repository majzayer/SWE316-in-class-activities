abstract class Button {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    public void render() {
        System.out.println("Rendering button: " + label);
    }

    public abstract void onClick();
}

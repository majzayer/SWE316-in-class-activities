public abstract class MenuComponent {
    protected final String name;

    protected MenuComponent(String name) {
        this.name = name;
    }

    public abstract void print();
}
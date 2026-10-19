import java.util.List;

public abstract class MenuComponent {
    protected String name;

    protected MenuComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(MenuComponent child) {
        throw new UnsupportedOperationException(
                "This component cannot contain children.");
    }

    public void remove(MenuComponent child) {
        throw new UnsupportedOperationException(
                "This component cannot contain children.");
    }

    public List<MenuComponent> getChildren() {
        throw new UnsupportedOperationException(
                "Only menus can have children.");
    }

    public MenuComponent findByName(MenuComponent current, String name) {
        if (current.getName().equalsIgnoreCase(name)) {
            return current;
        }

        return null;
    }

    public abstract void print();
}
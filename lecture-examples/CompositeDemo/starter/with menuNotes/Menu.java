import java.util.List;

public class Menu extends MenuComponent {
    private final List<MenuComponent> children;

    public Menu(String name, List<MenuComponent> children) {
        super(name);
        this.children = children;
    }

    @Override
    public void print() {
        System.out.println(name);

        for (MenuComponent child : children) {
            child.print();
        }
    }
}
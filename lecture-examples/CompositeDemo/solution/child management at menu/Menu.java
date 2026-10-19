import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu extends MenuComponent {
    private final List<MenuComponent> children;

    public Menu(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void add(MenuComponent child) {
        if (child == this) {
            throw new IllegalArgumentException(
                    "A menu cannot contain itself.");
        }

        children.add(child);
    }

    public void remove(MenuComponent child) {
        children.remove(child);
    }

    public List<MenuComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean removeByName(String childName) {
        for (int index = 0; index < children.size(); index++) {
            if (children.get(index).getName().equalsIgnoreCase(childName)) {
                children.remove(index);
                return true;
            }
        }

        return false;
    }

    public MenuComponent findByName(MenuComponent current, String name) {
        if (current.getName().equalsIgnoreCase(name)) {
            return current;
        }

        if (current instanceof Menu menu) {
            for (MenuComponent child : menu.children) {
                MenuComponent found = findByName(child, name);

                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }

    @Override
    public void print() {
        System.out.println(name);

        for (MenuComponent child : children) {
            child.print();
        }
    }
}
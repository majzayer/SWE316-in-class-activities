import java.util.List;

public class Menu {
    private final String name;
    private final List<MenuItem> items;
    private final List<Menu> submenus;

    public Menu(String name,
                List<MenuItem> items,
                List<Menu> submenus) {
        this.name = name;
        this.items = items;
        this.submenus = submenus;
    }

    public void printMenu() {
        System.out.println(name);

        for (MenuItem item : items) {
            item.printItem();
        }

        for (Menu submenu : submenus) {
            submenu.printMenu();
        }
    }
}
public class MenuManager {
    private final Menu menu;

    public MenuManager(String rootMenuName) {
        this.menu = new Menu(rootMenuName);
    }

    public void addMenu(String parentMenuName, String menuName) {
        findMenu(parentMenuName).add(new Menu(menuName));
    }

    public void addItem(String parentMenuName, String itemName, double price) {
        findMenu(parentMenuName).add(new MenuItem(itemName, price));
    }

    public void addNote(String parentMenuName, String text) {
        findMenu(parentMenuName).add(new MenuNote(text));
    }

    public boolean remove(String parentMenuName, String childName) {
        return findMenu(parentMenuName).removeByName(childName);
    }

    public MenuComponent findByName(String name) {
        return menu.findByName(menu, name);
    }

    public void printMenu() {
        menu.print();
    }

    private Menu findMenu(String name) {
        MenuComponent component = menu.findByName(menu, name);
        if (component instanceof Menu foundMenu) {
            return foundMenu;
        }

        throw new IllegalArgumentException("Menu not found: " + name);
    }
}
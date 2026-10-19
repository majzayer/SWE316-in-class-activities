public class MenuManager {
    private Menu menu;

    public MenuManager(Menu menu) {
        this.menu = menu;
    }

    public void printMenu() {
        menu.printMenu();
    }
}
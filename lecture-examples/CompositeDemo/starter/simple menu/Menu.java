import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> items;

    public Menu(String name, List<MenuItem> items) {
        this.name = name;
        this.items = items;
    }

    public void printMenu() {
        System.out.println(name);

        for (MenuItem item : items) {
            item.printItem();
        }
    }
}
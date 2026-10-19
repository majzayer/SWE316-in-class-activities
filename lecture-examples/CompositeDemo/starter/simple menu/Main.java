import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> items = Arrays.asList(
                new MenuItem("Soup", 18),
                new MenuItem("Salad", 20),
                new MenuItem("Chef's Special", 48),
                new MenuItem("Grilled Chicken", 38),
                new MenuItem("Steak", 65),
                new MenuItem("Cheesecake", 24),
                new MenuItem("Vanilla Ice Cream", 12),
                new MenuItem("Chocolate Ice Cream", 14)
        );

        Menu dinnerMenu = new Menu("THE OLIVE TABLE - DINNER MENU", items);
        MenuManager menuManager = new MenuManager(dinnerMenu);
        menuManager.printMenu();
    }
}

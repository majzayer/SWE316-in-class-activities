import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Menu starters = new Menu(
                "STARTERS",
                Arrays.asList(
                        new MenuItem("Soup", 18),
                        new MenuItem("Salad", 20)
                ),
                Collections.emptyList()
        );

        Menu grills = new Menu(
                "GRILLS",
                Arrays.asList(
                        new MenuItem("Grilled Chicken", 38),
                        new MenuItem("Steak", 65)
                ),
                Collections.emptyList()
        );

        Menu iceCream = new Menu(
                "ICE CREAM",
                Arrays.asList(
                        new MenuItem("Vanilla", 12),
                        new MenuItem("Chocolate", 14)
                ),
                Collections.emptyList()
        );

        Menu desserts = new Menu(
                "DESSERTS",
                Arrays.asList(new MenuItem("Cheesecake", 24)),
                Arrays.asList(iceCream)
        );

        Menu dinnerMenu = new Menu(
                "THE OLIVE TABLE - DINNER MENU",
                Arrays.asList(new MenuItem("Chef's Special", 48)),
                Arrays.asList(starters, grills, desserts)
        );

        MenuManager menuManager = new MenuManager(dinnerMenu);
        menuManager.printMenu();
    }
}
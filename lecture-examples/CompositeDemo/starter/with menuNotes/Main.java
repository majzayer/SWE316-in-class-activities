import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuComponent> children = new ArrayList<>();

        Menu dinnerMenu = new Menu("dinner", children);
        
        children.add(new MenuItem("Pasta", 32));
        children.add(dinnerMenu); 
        
        MenuManager menuManager = new MenuManager(dinnerMenu);
        menuManager.printMenu();
    }
}
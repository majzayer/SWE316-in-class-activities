
public class Main {
    public static void main(String[] args) {
        
        MenuManager menuManager = new MenuManager("THE OLIVE TABLE - DINNER MENU");
        populateMenu(menuManager);
        MenuItem item = (MenuItem) menuManager.findByName("Soup");
        item.add(new MenuNote("Ask your server about allergens before ordering."));
        addEndNote(menuManager.findByName("THE OLIVE TABLE - DINNER MENU"));
        menuManager.printMenu();
    }

    private static void populateMenu(MenuManager menuManager) {
        menuManager.addNote("THE OLIVE TABLE - DINNER MENU", "Dinner served from 6 p.m. to 11 p.m.");

        menuManager.addMenu("THE OLIVE TABLE - DINNER MENU", "STARTERS");
        menuManager.addItem("STARTERS", "Soup", 18);
        menuManager.addItem("STARTERS", "Salad", 20);
        menuManager.addItem("THE OLIVE TABLE - DINNER MENU", "Chef's Special", 48);
        menuManager.addNote("THE OLIVE TABLE - DINNER MENU", "Ask your server about today's special.");

        menuManager.addMenu("THE OLIVE TABLE - DINNER MENU", "GRILLS");
        menuManager.addItem("GRILLS", "Grilled Chicken", 38);
        menuManager.addItem("GRILLS", "Steak", 65);

        menuManager.addMenu("THE OLIVE TABLE - DINNER MENU", "DESSERTS");
        menuManager.addItem("DESSERTS", "Cheesecake", 24);
        menuManager.addNote("DESSERTS", "Ask your server about allergens before ordering.");
        menuManager.addMenu("DESSERTS", "ICE CREAM");
        menuManager.addItem("ICE CREAM", "Vanilla", 12);
        menuManager.addItem("ICE CREAM", "Chocolate", 14);
    }

    private static void addEndNote(MenuComponent current) {
        try {
            current.add(new MenuNote("End of " + current.getName() + " menu."));

            for(MenuComponent child : current.getChildren()) {
                addEndNote(child);
            }
            
        } catch (UnsupportedOperationException exception) {
            System.out.println("Only menus can have an end note.");
        }
    }


}
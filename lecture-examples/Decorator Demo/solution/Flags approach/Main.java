public class Main {
    public static void printMenuItem(String label, Beverage beverage) {
        System.out.printf("%-20s %.2f%n", label, beverage.cost());
    }

    public static void main(String[] args) {
        System.out.println("Starbuzz Coffee");
        System.out.println("Coffees");

        printMenuItem("House Blend", new HouseBlend());
        printMenuItem("Dark Roast", new DarkRoast());
        printMenuItem("Decaf", new Decaf());
        printMenuItem("Espresso", new Espresso());

        System.out.println();
        System.out.println("Condiments");
        System.out.printf("%-20s %.2f%n", "Steamed Milk", 0.10);
        System.out.printf("%-20s %.2f%n", "Mocha", 0.15);
        System.out.printf("%-20s %.2f%n", "Soy", 0.10);
        System.out.printf("%-20s %.2f%n", "Whip", 0.10);

        System.out.println();
        Beverage customCoffee = new Espresso();
        customCoffee.setMilk(true);
        customCoffee.setMocha(true);
        customCoffee.setWhip(true);

        System.out.println(customCoffee.getDescription());
        System.out.printf("Total: $%.2f%n", customCoffee.cost());
    }
}

public class Main {
    private Main() {
        // Application entry-point class.
    }

    public static void main(String[] args) {
        DeliveryPlatform platform = new DeliveryPlatform("Wasel");

        Restaurant restaurant = new Restaurant("Eastern Kitchen");
        MenuItem kabsa = new MenuItem("Chicken Kabsa", 42.00);
        MenuItem salad = new MenuItem("Green Salad", 12.00);
        restaurant.addMenuItem(kabsa);
        restaurant.addMenuItem(salad);
        platform.registerRestaurant(restaurant);

        Customer customer = new Customer("Sara", "0500000000");
        Order order = new Order(customer, "MADA");
        order.addItem(kabsa, 3);
        order.addItem(salad, 1);

        System.out.println("Platform: " + platform.getName());
        System.out.println("Restaurant: " + restaurant.getName());

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(order);

        System.out.println("\nOrder paid after checkout: " + order.isPaid());
    }
}


public class ReceiptPrinter {
    private ReceiptPrinter() {
        // Utility class: prevent instantiation.
    }

    public static void print(Order order) {
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Order: " + order.getNumber());
        System.out.println("Customer: " + order.getCustomer().getName());

        order.forEachLine((menuItem, quantity) -> {
            System.out.printf(
                    "%d x %-20s SAR %.2f%n",
                quantity,
                menuItem.getName(),
                menuItem.getPrice() * quantity);
        });

        System.out.printf("Total: SAR %.2f%n", order.calculateTotal());
        System.out.println("Status: " + (order.isPaid() ? "PAID" : "UNPAID"));
    }
}


public class ReceiptPrinter {
    private ReceiptPrinter() {
        // Utility class: prevent instantiation.
    }

    public static void print(Order order) {
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Order: " + order.getNumber());
        System.out.println("Customer: " + order.getCustomer().getName());

        for (Order.OrderLine line : order.getOrderLines()) {
            System.out.printf(
                    "%d x %-20s SAR %.2f%n",
                    line.getQuantity(),
                    line.getMenuItem().getName(),
                    line.calculateSubtotal());
        }

        System.out.printf("Total: SAR %.2f%n", order.calculateTotal());
        System.out.println("Status: " + (order.isPaid() ? "PAID" : "UNPAID"));
    }

}


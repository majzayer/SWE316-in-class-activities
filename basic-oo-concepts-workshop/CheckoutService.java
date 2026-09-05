public class CheckoutService {

    public void checkout(Order order) {
        double amount = order.calculateTotal();

        if (order.getPaymentType().equals("CASH")) {
            System.out.printf("SAR %.2f will be collected on delivery.%n", amount);
            order.markAsPaid();
        } else if (order.getPaymentType().equals("MADA")) {
            System.out.printf("Processing SAR %.2f through Mada...%n", amount);

            if (amount <= 100.00) {
                System.out.println("Mada payment approved.");
                order.markAsPaid();
            } else {
                System.out.println("Mada payment declined.");
            }
        } else {
            throw new IllegalArgumentException(
                    "Unsupported payment method: " + order.getPaymentType());
        }

        ReceiptPrinter.print(order);
    }
}


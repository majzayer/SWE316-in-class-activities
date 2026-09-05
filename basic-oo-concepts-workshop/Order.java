import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private static int nextNumber = 1000;

    private int number;
    private Customer customer;
    private List<OrderLine> orderLines = new ArrayList<>();
    private String paymentType;
    private boolean paid;

    public Order(Customer customer, String paymentType) {
        this.number = nextNumber++;
        this.customer = customer;
        this.paymentType = paymentType;
    }

    public void addItem(MenuItem menuItem, int quantity) {
        orderLines.add(new OrderLine(menuItem, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderLine line : orderLines) {
            total += line.calculateSubtotal();
        }
        return total;
    }

    public void markAsPaid() {
        paid = true;
    }

    public int getNumber() {
        return number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderLine> getOrderLines() {
        return Collections.unmodifiableList(orderLines);
    }

    public String getPaymentType() {
        return paymentType;
    }

    public boolean isPaid() {
        return paid;
    }

    public static class OrderLine {
        private MenuItem menuItem;
        private int quantity;

        private OrderLine(MenuItem menuItem, int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            this.menuItem = menuItem;
            this.quantity = quantity;
        }

        public MenuItem getMenuItem() {
            return menuItem;
        }

        public int getQuantity() {
            return quantity;
        }

        public double calculateSubtotal() {
            return menuItem.getPrice() * quantity;
        }
    }
}


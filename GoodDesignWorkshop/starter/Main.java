import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;
    private boolean available;

    public MenuItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }
}

abstract class FoodOrder {
    private List<MenuItem> items;
    private double subtotal;
    private double discount;
    private double deliveryFee;
    private double total;
    private String status;

    public FoodOrder(List<MenuItem> items) {
        this.items = new ArrayList<>(items);
        this.status = "NEW";
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class DeliveryOrder extends FoodOrder {
    private String deliveryAddress;
    private boolean courierAssigned;

    public DeliveryOrder(
            List<MenuItem> items,
            String deliveryAddress) {

        super(items);
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setCourierAssigned(boolean courierAssigned) {
        this.courierAssigned = courierAssigned;
    }
}

class PickupOrder extends FoodOrder {
    private String branch;
    private String pickupCode;

    public PickupOrder(
            List<MenuItem> items,
            String branch) {

        super(items);
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setPickupCode(String pickupCode) {
        this.pickupCode = pickupCode;
    }
}

class OrderService {

    public void placeOrder(
            FoodOrder order,
            boolean delivery) {

        order.getItems().removeIf(
                item -> !item.isAvailable());

        double subtotal = 0;

        for (MenuItem item : order.getItems()) {
            subtotal += item.getPrice();
        }

        order.setSubtotal(subtotal);

        if (subtotal >= 100) {
            order.setDiscount(subtotal * 0.10);
        } else {
            order.setDiscount(0);
        }

        if (delivery) {
            DeliveryOrder deliveryOrder =
                    (DeliveryOrder) order;

            order.setDeliveryFee(15);
            deliveryOrder.setCourierAssigned(true);
            order.setStatus("WAITING_FOR_COURIER");
        } else {
            PickupOrder pickupOrder =
                    (PickupOrder) order;

            order.setDeliveryFee(0);
            pickupOrder.setPickupCode("P-104");
            order.setStatus("READY_FOR_PICKUP");
        }

        double total =
                order.getSubtotal()
                - order.getDiscount()
                + order.getDeliveryFee();

        order.setTotal(total);
    }
}

public class Main {
    public static void main(String[] args) {
        List<MenuItem> items = List.of(
                new MenuItem("Burger", 35, true),
                new MenuItem("Pizza", 45, true),
                new MenuItem("Juice", 12, false)
        );

        FoodOrder order =
                new DeliveryOrder(
                        items,
                        "King Fahd Road");

        OrderService service = new OrderService();
        service.placeOrder(order, true);
    }
}

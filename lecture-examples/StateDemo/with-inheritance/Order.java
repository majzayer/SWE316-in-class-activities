import java.time.LocalDateTime;
import java.util.UUID;

// State transitions return a new instance with the same order ID; callers must keep the returned reference.
public abstract class Order {
    private final String orderId;
    private String deliveryAddress;
    private LocalDateTime preparationTime;

    protected Order(String deliveryAddress) {
        this(UUID.randomUUID().toString(), deliveryAddress, null);
    }

    protected Order(String deliveryAddress, LocalDateTime preparationTime) {
        this(UUID.randomUUID().toString(), deliveryAddress, preparationTime);
    }

    protected Order(Order previous) {
        this(previous.orderId, previous.deliveryAddress, previous.preparationTime);
    }

    protected Order(Order previous, LocalDateTime preparationTime) {
        this(previous.orderId, previous.deliveryAddress, preparationTime);
    }

    private Order(String orderId, String deliveryAddress, LocalDateTime preparationTime) {
        this.orderId = orderId;
        this.deliveryAddress = requireAddress(deliveryAddress);
        this.preparationTime = preparationTime;
    }

    public abstract OrderStatus getStatus();

    public String getOrderId() {
        return orderId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getPreparationTime() {
        return preparationTime;
    }

    public Order confirm() {
        throw cannot("confirm");
    }

    public Order reschedule(LocalDateTime newPreparationTime) {
        throw cannot("reschedule");
    }

    public Order preparationTimeArrives() {
        throw cannot("start preparation");
    }

    public Order cancel() {
        throw cannot("cancel");
    }

    public void changeDeliveryAddress(String address) {
        throw cannot("change the delivery address");
    }

    public Order markReady() {
        throw cannot("mark ready");
    }

    public Order pickUpOrder() {
        throw cannot("pick up");
    }

    public Order deliverOrder() {
        throw cannot("deliver");
    }

    protected final void setDeliveryAddress(String address) {
        deliveryAddress = requireAddress(address);
    }

    protected final IllegalStateException cannot(String operation) {
        return new IllegalStateException(
                "Cannot " + operation + " when the order status is " + getStatus() + ".");
    }

    protected final void refund() {
        System.out.println("Order cancelled; issue a full refund.");
    }

    protected final void refundMinusPreparationFee() {
        System.out.println("Order cancelled; refund minus a preparation fee.");
    }

    protected final void updateOrder() {
        System.out.println("Delivery address updated.");
    }

    protected final void notifyAssignedDriver() {
        System.out.println("Assigned driver notified.");
    }

    protected final void reroute() {
        System.out.println("Reroute request submitted to the driver.");
    }

    protected static LocalDateTime requireFuturePreparationTime(LocalDateTime preparationTime) {
        if (preparationTime == null || !preparationTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Preparation time must be in the future.");
        }
        return preparationTime;
    }

    private static String requireAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Delivery address cannot be null or blank.");
        }
        return address;
    }
}

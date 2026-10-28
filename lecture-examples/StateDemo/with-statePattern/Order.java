import java.time.LocalDateTime;

public class Order {
    private OrderState state;
    private String deliveryAddress;
    private LocalDateTime preparationTime;

    public Order(String deliveryAddress) {
        setDeliveryAddress(deliveryAddress);
        state = new PendingState();
    }

    public Order(String deliveryAddress, LocalDateTime preparationTime) {
        setDeliveryAddress(deliveryAddress);
        this.preparationTime = requireFuturePreparationTime(preparationTime);
        state = new ScheduledState();
    }

    public OrderStatus getStatus() {
        return state.getStatus();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getPreparationTime() {
        return preparationTime;
    }

    public void confirm() {
        state.confirm(this);
    }

    public void preparationTimeArrives() {
        state.preparationTimeArrives(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void changeDeliveryAddress(String address) {
        state.changeDeliveryAddress(this, address);
    }

    public void markReady() {
        state.markReady(this);
    }

    public void pickUpOrder() {
        state.pickUpOrder(this);
    }

    public void deliverOrder() {
        state.deliverOrder(this);
    }

    void setState(OrderState state) {
        this.state = state;
    }

    void setDeliveryAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Delivery address cannot be null or blank.");
        }
        deliveryAddress = address;
    }

    void refund() {
        System.out.println("Order cancelled; issue a full refund.");
    }

    void refundMinusPreparationFee() {
        System.out.println("Order cancelled; refund minus a preparation fee.");
    }

    void updateOrder() {
        System.out.println("Delivery address updated.");
    }

    void notifyAssignedDriver() {
        System.out.println("Assigned driver notified.");
    }

    void reroute() {
        System.out.println("Reroute request submitted to the driver.");
    }

    private static LocalDateTime requireFuturePreparationTime(LocalDateTime preparationTime) {
        if (preparationTime == null || !preparationTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Preparation time must be in the future.");
        }
        return preparationTime;
    }
}

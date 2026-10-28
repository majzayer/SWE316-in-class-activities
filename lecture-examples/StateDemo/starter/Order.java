
public class Order {
    private OrderStatus status;
    private String deliveryAddress;

    public Order(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        this.status = OrderStatus.PENDING;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void confirm() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException(
                    "Cannot confirm when the order status is " + status + ".");
        }
        status = OrderStatus.PREPARING;
    }

    public void markReady() {
        if (status != OrderStatus.PREPARING) {
            throw new IllegalStateException(
                    "Cannot mark the order ready when the order status is " + status + ".");
        }
        status = OrderStatus.READY_FOR_PICKUP;
    }

    public void pickUpOrder() {
        if (status != OrderStatus.READY_FOR_PICKUP) {
            throw new IllegalStateException(
                    "Cannot pick up the order when the order status is " + status + ".");
        }
        status = OrderStatus.OUT_FOR_DELIVERY;
    }

    public void deliverOrder() {
        if (status != OrderStatus.OUT_FOR_DELIVERY) {
            throw new IllegalStateException(
                    "Cannot deliver the order when the order status is " + status + ".");
        }
        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException(
                    "Cannot cancel when the order status is " + status + ".");
        }
        status = OrderStatus.CANCELLED;
    }

    public void changeDeliveryAddress(String address) {
        if (status != OrderStatus.PENDING) {
            throw new IllegalStateException(
                    "Cannot change the delivery address when the order status is " + status + ".");
        }
        deliveryAddress = address;
    }

}

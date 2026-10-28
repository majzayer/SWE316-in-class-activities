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
                    "Cannot mark ready when the order status is " + status + ".");
        }
        status = OrderStatus.READY_FOR_PICKUP;
    }

    public void pickUpOrder() {
        if (status != OrderStatus.READY_FOR_PICKUP) {
            throw new IllegalStateException(
                    "Cannot pick up when the order status is " + status + ".");
        }
        status = OrderStatus.OUT_FOR_DELIVERY;
    }

    public void deliverOrder() {
        if (status != OrderStatus.OUT_FOR_DELIVERY) {
            throw new IllegalStateException(
                    "Cannot deliver when the order status is " + status + ".");
        }
        status = OrderStatus.DELIVERED;
    }

    private void refund() {
        System.out.println("Order cancelled; issue a full refund.");
    }

    private void refundMinusPreparationFee() {
        System.out.println("Order cancelled; refund minus a preparation fee.");
    }

    private void updateOrder() {
        System.out.println("Delivery address updated.");
    }

    private void notifyAssignedDriver() {
        System.out.println("Assigned driver notified.");
    }

    private void reroute() {
        System.out.println("Reroute request submitted to the driver.");
    }

    public void cancel() {
        if (status == OrderStatus.PENDING) {
            status = OrderStatus.CANCELLED;
            refund();
            return;
        }
        if (status == OrderStatus.PREPARING) {
            status = OrderStatus.CANCELLED;
            refundMinusPreparationFee();
            return;
        }
        throw new IllegalStateException("Cannot cancel when the order status is " + status + ".");
    }

    public void changeDeliveryAddress(String address) {
        
        switch (status) {
            case PENDING:
            case PREPARING:
                deliveryAddress = address;
                return;
            case READY_FOR_PICKUP:
                deliveryAddress = address;
                notifyAssignedDriver();
                return;
            case OUT_FOR_DELIVERY:
                deliveryAddress = address;
                reroute();
                return;
            default:
                throw new IllegalStateException(
                        "Cannot change the delivery address when the order status is " + status + ".");
        }
    }
}

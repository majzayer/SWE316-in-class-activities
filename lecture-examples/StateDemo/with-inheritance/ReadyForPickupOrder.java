public class ReadyForPickupOrder extends Order {
    protected ReadyForPickupOrder(Order previous) {
        super(previous);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.READY_FOR_PICKUP;
    }

    @Override
    public void changeDeliveryAddress(String address) {
        setDeliveryAddress(address);
        updateOrder();
        notifyAssignedDriver();
    }

    @Override
    public Order pickUpOrder() {
        return new OutForDeliveryOrder(this);
    }
}

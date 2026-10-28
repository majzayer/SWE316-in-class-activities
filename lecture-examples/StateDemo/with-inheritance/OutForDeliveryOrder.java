public class OutForDeliveryOrder extends Order {
    protected OutForDeliveryOrder(Order previous) {
        super(previous);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.OUT_FOR_DELIVERY;
    }

    @Override
    public void changeDeliveryAddress(String address) {
        setDeliveryAddress(address);
        reroute();
    }

    @Override
    public Order deliverOrder() {
        return new DeliveredOrder(this);
    }
}

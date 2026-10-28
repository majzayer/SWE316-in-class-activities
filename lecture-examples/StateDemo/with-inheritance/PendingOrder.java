public class PendingOrder extends Order {
    public PendingOrder(String deliveryAddress) {
        super(deliveryAddress);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.PENDING;
    }

    @Override
    public Order confirm() {
        return new PreparingOrder(this);
    }

    @Override
    public Order cancel() {
        refund();
        return new CancelledOrder(this);
    }

    @Override
    public void changeDeliveryAddress(String address) {
        setDeliveryAddress(address);
        updateOrder();
    }
}

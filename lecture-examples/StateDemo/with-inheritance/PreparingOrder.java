public class PreparingOrder extends Order {
    public PreparingOrder(String deliveryAddress) {
        super(deliveryAddress);
    }

    protected PreparingOrder(Order previous) {
        super(previous);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.PREPARING;
    }

    @Override
    public Order cancel() {
        refundMinusPreparationFee();
        return new CancelledOrder(this);
    }

    @Override
    public void changeDeliveryAddress(String address) {
        setDeliveryAddress(address);
        updateOrder();
    }

    @Override
    public Order markReady() {
        return new ReadyForPickupOrder(this);
    }
}

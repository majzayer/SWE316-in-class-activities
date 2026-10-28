public class DeliveredOrder extends Order {
    protected DeliveredOrder(Order previous) {
        super(previous);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.DELIVERED;
    }
}

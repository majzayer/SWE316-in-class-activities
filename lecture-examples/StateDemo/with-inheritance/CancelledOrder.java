public class CancelledOrder extends Order {
    protected CancelledOrder(Order previous) {
        super(previous);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.CANCELLED;
    }
}

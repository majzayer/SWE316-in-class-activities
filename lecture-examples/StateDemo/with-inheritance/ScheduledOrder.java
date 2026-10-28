import java.time.LocalDateTime;

public class ScheduledOrder extends Order {
    public ScheduledOrder(String deliveryAddress, LocalDateTime preparationTime) {
        super(deliveryAddress, requireFuturePreparationTime(preparationTime));
    }

    private ScheduledOrder(Order previous, LocalDateTime preparationTime) {
        super(previous, preparationTime);
    }

    @Override
    public OrderStatus getStatus() {
        return OrderStatus.SCHEDULED;
    }

    @Override
    public Order reschedule(LocalDateTime newPreparationTime) {
        requireFuturePreparationTime(newPreparationTime);
        System.out.println("Order rescheduled.");
        return new ScheduledOrder(this, newPreparationTime);
    }

    @Override
    public Order preparationTimeArrives() {
        if (LocalDateTime.now().isBefore(getPreparationTime())) {
            throw new IllegalStateException("Cannot start preparation before the scheduled time.");
        }
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

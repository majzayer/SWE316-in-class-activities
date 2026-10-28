import java.time.LocalDateTime;

class ScheduledState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.SCHEDULED;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException("Cannot " + operation + " when the order status is SCHEDULED.");
    }

    @Override
    public void confirm(Order order) {
        throw cannot("confirm");
    }

    @Override
    public void preparationTimeArrives(Order order) {
        if (LocalDateTime.now().isBefore(order.getPreparationTime())) {
            throw new IllegalStateException("Cannot start preparation before the scheduled time.");
        }
        order.setState(new PreparingState());
    }

    @Override
    public void cancel(Order order) {
        order.refund();
        order.setState(new CancelledState());
    }

    @Override
    public void changeDeliveryAddress(Order order, String address) {
        order.setDeliveryAddress(address);
        order.updateOrder();
    }

    @Override
    public void markReady(Order order) {
        throw cannot("mark ready");
    }

    @Override
    public void pickUpOrder(Order order) {
        throw cannot("pick up");
    }

    @Override
    public void deliverOrder(Order order) {
        throw cannot("deliver");
    }
}

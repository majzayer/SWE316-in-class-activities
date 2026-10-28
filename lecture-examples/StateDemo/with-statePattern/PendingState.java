class PendingState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.PENDING;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException("Cannot " + operation + " when the order status is PENDING.");
    }

    @Override
    public void confirm(Order order) {
        order.setState(new PreparingState());
    }

    @Override
    public void preparationTimeArrives(Order order) {
        throw cannot("start preparation");
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

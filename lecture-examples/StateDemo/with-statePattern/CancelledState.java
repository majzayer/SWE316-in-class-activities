class CancelledState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.CANCELLED;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException("Cannot " + operation + " when the order status is CANCELLED.");
    }

    @Override
    public void confirm(Order order) {
        throw cannot("confirm");
    }

    @Override
    public void preparationTimeArrives(Order order) {
        throw cannot("start preparation");
    }

    @Override
    public void cancel(Order order) {
        throw cannot("cancel");
    }

    @Override
    public void changeDeliveryAddress(Order order, String address) {
        throw cannot("change the delivery address");
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

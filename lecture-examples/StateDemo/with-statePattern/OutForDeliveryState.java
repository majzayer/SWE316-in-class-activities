class OutForDeliveryState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.OUT_FOR_DELIVERY;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException(
                "Cannot " + operation + " when the order status is OUT_FOR_DELIVERY.");
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
        order.setDeliveryAddress(address);
        order.reroute();
    }

    @Override
    public void deliverOrder(Order order) {
        order.setState(new DeliveredState());
    }

    @Override
    public void markReady(Order order) {
        throw cannot("mark ready");
    }

    @Override
    public void pickUpOrder(Order order) {
        throw cannot("pick up");
    }
}

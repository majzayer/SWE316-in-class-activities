class ReadyForPickupState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.READY_FOR_PICKUP;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException(
                "Cannot " + operation + " when the order status is READY_FOR_PICKUP.");
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
        order.updateOrder();
        order.notifyAssignedDriver();
    }

    @Override
    public void pickUpOrder(Order order) {
        order.setState(new OutForDeliveryState());
    }

    @Override
    public void markReady(Order order) {
        throw cannot("mark ready");
    }

    @Override
    public void deliverOrder(Order order) {
        throw cannot("deliver");
    }
}

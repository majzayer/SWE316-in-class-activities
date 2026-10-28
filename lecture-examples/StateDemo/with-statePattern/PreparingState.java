class PreparingState implements OrderState {
    @Override
    public OrderStatus getStatus() {
        return OrderStatus.PREPARING;
    }

    private IllegalStateException cannot(String operation) {
        return new IllegalStateException("Cannot " + operation + " when the order status is PREPARING.");
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
        order.refundMinusPreparationFee();
        order.setState(new CancelledState());
    }

    @Override
    public void changeDeliveryAddress(Order order, String address) {
        order.setDeliveryAddress(address);
        order.updateOrder();
    }

    @Override
    public void markReady(Order order) {
        order.setState(new ReadyForPickupState());
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

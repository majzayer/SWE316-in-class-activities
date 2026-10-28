public interface OrderState {
    OrderStatus getStatus();

    void confirm(Order order);

    void preparationTimeArrives(Order order);

    void cancel(Order order);

    void changeDeliveryAddress(Order order, String address);

    void markReady(Order order);

    void pickUpOrder(Order order);

    void deliverOrder(Order order);
}

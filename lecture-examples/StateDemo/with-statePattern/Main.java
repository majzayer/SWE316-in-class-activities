import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Order immediateOrder = new Order("12 Main Street");
        printStatus("Immediate order placed", immediateOrder);

        immediateOrder.changeDeliveryAddress("24 Main Street");
        immediateOrder.confirm();
        printStatus("Order confirmed", immediateOrder);

        immediateOrder.markReady();
        immediateOrder.changeDeliveryAddress("8 Oak Avenue");
        immediateOrder.pickUpOrder();
        immediateOrder.changeDeliveryAddress("16 Pine Road");
        immediateOrder.deliverOrder();
        printStatus("Order delivered", immediateOrder);

        LocalDateTime preparationTime = LocalDateTime.now().plusSeconds(2);
        Order scheduledOrder = new Order("5 Cedar Lane", preparationTime);
        printStatus("Scheduled order placed", scheduledOrder);

        while (LocalDateTime.now().isBefore(preparationTime)) {
            Thread.sleep(100);
        }

        scheduledOrder.preparationTimeArrives();
        printStatus("Scheduled preparation started", scheduledOrder);
        scheduledOrder.markReady();
        scheduledOrder.pickUpOrder();
        scheduledOrder.deliverOrder();
        printStatus("Scheduled order delivered", scheduledOrder);
    }

    private static void printStatus(String message, Order order) {
        System.out.println(message + ": " + order.getStatus()
                + " (delivery address: " + order.getDeliveryAddress() + ")");
    }
}

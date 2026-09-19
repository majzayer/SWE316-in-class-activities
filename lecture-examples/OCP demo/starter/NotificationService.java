public class NotificationService {

    public void sendConfirmation(Order order) {
        System.out.println("Confirmation sent for order total: " + order.getTotal());
    }
}
public class Main {
    public static void main(String[] args) {
        Order order = new PendingOrder("12 Main Street");
        Order clientReference = order;

        System.out.println("Before confirmation:");
        System.out.println("order status: " + order.getStatus());
        System.out.println("clientReference status: " + clientReference.getStatus());

        order = order.confirm();

        System.out.println("\nAfter confirmation without updating clientReference:");
        System.out.println("order status: " + order.getStatus());
        System.out.println("clientReference status: " + clientReference.getStatus());

        clientReference = order;
        System.out.println("\nAfter updating clientReference:");
        System.out.println("clientReference status: " + clientReference.getStatus());
    }
}

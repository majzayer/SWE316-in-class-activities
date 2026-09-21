public class CheckoutService {

    private PaymentGateway paymentGateway;
    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public CheckoutService(
            PaymentGateway paymentGateway,
            OrderRepository orderRepository,
            NotificationService notificationService) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public Order checkout(
            ShoppingCart cart,
            String shippingType,
            PaymentDetails paymentDetails) {

        double subtotal = cart.calculateSubtotal();
        double shippingCost;

        if (shippingType.equals("STANDARD")) {
            shippingCost = cart.getWeight() * 5;
        } else if (shippingType.equals("EXPRESS")) {
            shippingCost = cart.getWeight() * 10;
        } else {
            throw new IllegalArgumentException("Unknown shipping type");
        }

        double total = subtotal + shippingCost;

        paymentGateway.charge(paymentDetails, total);
        Order order = orderRepository.save(cart, total);
        notificationService.sendConfirmation(order);

        return order;
    }
}
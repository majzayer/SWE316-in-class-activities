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
            ShippingMethod shippingMethod,
            PaymentDetails paymentDetails) {

        double subtotal = cart.calculateSubtotal();
        double shippingCost = shippingMethod.calculateCost(cart);
        double total = subtotal + shippingCost;

        paymentGateway.charge(paymentDetails, total);
        Order order = orderRepository.save(cart, total);
        notificationService.sendConfirmation(order);

        return order;
    }
}
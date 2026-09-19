public class OrderRepository {

    public Order save(ShoppingCart cart, double total) {
        return new Order(cart, total);
    }
}
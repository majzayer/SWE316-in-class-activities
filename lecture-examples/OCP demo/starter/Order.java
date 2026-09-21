public class Order {

    private ShoppingCart cart;
    private double total;

    public Order(ShoppingCart cart, double total) {
        this.cart = cart;
        this.total = total;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public double getTotal() {
        return total;
    }
}
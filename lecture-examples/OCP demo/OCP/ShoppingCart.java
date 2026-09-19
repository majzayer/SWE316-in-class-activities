public class ShoppingCart {

    private double subtotal;
    private double weight;

    public ShoppingCart(double subtotal, double weight) {
        this.subtotal = subtotal;
        this.weight = weight;
    }

    public double calculateSubtotal() {
        return subtotal;
    }

    public double getWeight() {
        return weight;
    }
}
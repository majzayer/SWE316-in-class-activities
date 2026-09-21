public class StandardShipping implements ShippingMethod {

    @Override
    public double calculateCost(ShoppingCart cart) {
        return cart.getWeight() * 5;
    }
}
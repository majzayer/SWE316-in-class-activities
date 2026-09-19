public class OvernightShipping implements ShippingMethod {

    @Override
    public double calculateCost(ShoppingCart cart) {
        return cart.getWeight() * 20;
    }
}
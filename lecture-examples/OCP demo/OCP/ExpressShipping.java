public class ExpressShipping implements ShippingMethod {

    @Override
    public double calculateCost(ShoppingCart cart) {
        return cart.getWeight() * 10;
    }
}
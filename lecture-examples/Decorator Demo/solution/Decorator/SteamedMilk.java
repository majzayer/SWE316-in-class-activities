public class SteamedMilk extends CondimentDecorator {
    public SteamedMilk(Beverage beverage) {
        super(beverage);
        description = "Steamed Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}

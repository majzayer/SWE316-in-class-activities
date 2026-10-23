public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
        description = "Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}

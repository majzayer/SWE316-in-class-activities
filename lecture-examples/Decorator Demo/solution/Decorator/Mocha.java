public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
        description = "Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15;
    }
}

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        super(beverage);
        description = "Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }
}

public class Beverage {
    protected String description = "Unknown Beverage";
    protected boolean milk;
    protected boolean soy;
    protected boolean mocha;
    protected boolean whip;

    public String getDescription() {
        StringBuilder result = new StringBuilder(description);

        if (milk) result.append(", Milk");
        if (soy) result.append(", Soy");
        if (mocha) result.append(", Mocha");
        if (whip) result.append(", Whip");

        return result.toString();
    }

    public double cost() {
        double total = 0.0;

        if (milk) total += 0.10;
        if (soy) total += 0.10;
        if (mocha) total += 0.15;
        if (whip) total += 0.10;

        return total;
    }

    public boolean hasMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean hasSoy() {
        return soy;
    }

    public void setSoy(boolean soy) {
        this.soy = soy;
    }

    public boolean hasMocha() {
        return mocha;
    }

    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }

    public boolean hasWhip() {
        return whip;
    }

    public void setWhip(boolean whip) {
        this.whip = whip;
    }
}

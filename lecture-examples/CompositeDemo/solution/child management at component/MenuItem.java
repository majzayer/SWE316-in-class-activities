public class MenuItem extends MenuComponent {
    private final double price;

    public MenuItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public void print() {
        System.out.printf("%s - SAR %.2f%n", name, price);
    }
}
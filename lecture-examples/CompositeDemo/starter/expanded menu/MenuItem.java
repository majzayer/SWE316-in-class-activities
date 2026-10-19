public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void printItem() {
        System.out.printf("%s - SAR %.2f%n", name, price);
    }
}
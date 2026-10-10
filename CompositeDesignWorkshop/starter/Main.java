public class Main {
    public static void main(String[] args) {
        DrawingGroup scene = new DrawingGroup("Scene");

        DrawingGroup house = new DrawingGroup("House");
        house.addRectangle(new Rectangle("Wall"));
        house.addRectangle(new Rectangle("Door"));

        scene.addRectangle(new Rectangle("Background"));
        scene.addGroup(house);
        scene.addCircle(new Circle("Sun"));

        scene.drawGroup();
    }
}

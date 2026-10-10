import java.util.ArrayList;
import java.util.List;

class Circle {
    private final String name;

    public Circle(String name) {
        this.name = name;
    }

    public void drawCircle() {
        System.out.println("Circle: " + name);
    }
}

class Rectangle {
    private final String name;

    public Rectangle(String name) {
        this.name = name;
    }

    public void drawRectangle() {
        System.out.println("Rectangle: " + name);
    }
}

class DrawingGroup {
    private final String name;
    private final List<Circle> circles = new ArrayList<>();
    private final List<Rectangle> rectangles = new ArrayList<>();
    private final List<DrawingGroup> groups = new ArrayList<>();

    public DrawingGroup(String name) {
        this.name = name;
    }

    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    public void addGroup(DrawingGroup group) {
        groups.add(group);
    }

    public void drawGroup() {
        System.out.println("Group: " + name);

        for (Circle circle : circles) {
            circle.drawCircle();
        }

        for (Rectangle rectangle : rectangles) {
            rectangle.drawRectangle();
        }

        for (DrawingGroup group : groups) {
            group.drawGroup();
        }
    }
}

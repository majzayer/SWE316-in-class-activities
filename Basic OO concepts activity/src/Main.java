import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ActivityReader reader = new ActivityFileReader("data/activities.txt");
        // ActivityReader reader = new ActivityDBReader("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

        List<VisualizationComponent> components = new ArrayList<>();
        components.add(new ScheduleView());
        components.add(new UtilizationChart());
        components.add(new ClassroomMenuView());

        VisualizationController controller = new VisualizationController(reader, components);

        Classroom selectedClassroom = new Classroom(125, 22);
        controller.refresh(selectedClassroom);
    }
}

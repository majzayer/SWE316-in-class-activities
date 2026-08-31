import java.util.List;

public class VisualizationController {
    private ActivityReader activityReader;
    private List<VisualizationComponent> visualizationComponents;

    public VisualizationController(ActivityReader activityReader, List<VisualizationComponent> visualizationComponents) {
        this.activityReader = activityReader;
        this.visualizationComponents = visualizationComponents;
    }

    public void refresh(Classroom selectedClassroom) {
        Activity[] activities = activityReader.getActivitiesFor(selectedClassroom);

        for (VisualizationComponent component : visualizationComponents) {
            component.setActivities(activities);
        }
    }
}

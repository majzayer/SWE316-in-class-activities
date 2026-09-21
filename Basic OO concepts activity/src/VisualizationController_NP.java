/**
 * Non-polymorphic alternative implementation of VisualizationController.
 * This demonstrates how the design would look without leveraging polymorphism.
 * Each view is explicitly held and updated, rather than using a generic list.
 */
public class VisualizationController_NP {
    private ActivityReader activityReader;
    private Activity[] activities;
    private ClassroomMenuView classroomMenu;
    private ScheduleView scheduleView;
    private UtilizationChart utilChart;

    public VisualizationController_NP(ActivityReader activityReader,
                                     ClassroomMenuView classroomMenu,
                                     ScheduleView scheduleView,
                                     UtilizationChart utilChart) {
        this.activityReader = activityReader;
        this.classroomMenu = classroomMenu;
        this.scheduleView = scheduleView;
        this.utilChart = utilChart;
    }

    public void refresh(Classroom selectedClassroom) {
        activities = activityReader.getActivitiesFor(selectedClassroom);

        classroomMenu.setActivities(activities);
        scheduleView.setActivities(activities);
        utilChart.setActivities(activities);
    }
}

public class ClassroomMenuView extends VisualizationComponent {
    @Override
    public void refresh() {
        System.out.println("ClassroomMenuView:");
        if (activities.length == 0) {
            System.out.println(" - No classroom selected");
            return;
        }
        System.out.println(" - " + activities[0].getClassroom().getClassroomFullAddress());
    }
}

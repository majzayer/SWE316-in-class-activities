public class ScheduleView extends VisualizationComponent {
    @Override
    public void refresh() {
        System.out.println("ScheduleView - " + getClassroomLabel());
        System.out.printf("%6s | %-24s | %-24s | %-24s | %-24s | %-24s%n",
                "Time", DAYS[0], DAYS[1], DAYS[2], DAYS[3], DAYS[4]);
        System.out.println("-------+--------------------------+--------------------------+--------------------------+--------------------------+--------------------------");

        for (int hour = FIRST_HOUR; hour < LAST_HOUR; hour++) {
            System.out.printf("%02d:00  |", hour);
            for (String day : DAYS) {
                System.out.printf(" %-24s |", getActivityLabel(day, hour));
            }
            System.out.println();
        }
    }

    private String getClassroomLabel() {
        if (activities.length == 0) {
            return "No classroom selected";
        }
        return activities[0].getClassroom().getClassroomFullAddress();
    }

    private String getActivityLabel(String day, int hour) {
        for (Activity activity : activities) {
            if (activity.getDays().contains(day)
                    && hour >= activity.getStart()
                    && hour < activity.getEnd()) {
                return activity.getCourse().getNumber() + " " + activity.getType()
                        + " (" + activity.getSection() + ")";
            }
        }
        return "";
    }
}

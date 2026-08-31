public class UtilizationChart extends VisualizationComponent {
    @Override
    public void refresh() {
        int occupiedHours = getOccupiedHours();
        int operatingHours = DAYS.length * (CLOSING_HOUR - OPENING_HOUR);
        double utilization = (double) occupiedHours / operatingHours * 100;

        String classroom = activities.length == 0
                ? "No classroom selected"
                : activities[0].getClassroom().getClassroomFullAddress();
        System.out.printf("UtilizationChart - %s: %.2f%% (%d/%d hours)%n",
                classroom, utilization, occupiedHours, operatingHours);
    }

    private int getOccupiedHours() {
        boolean[][] occupiedSlots = new boolean[DAYS.length][CLOSING_HOUR - OPENING_HOUR];

        for (Activity activity : activities) {
            for (int dayIndex = 0; dayIndex < DAYS.length; dayIndex++) {
                if (!activity.getDays().contains(DAYS[dayIndex])) {
                    continue;
                }

                int start = Math.max(activity.getStart(), OPENING_HOUR);
                int end = Math.min(activity.getEnd(), CLOSING_HOUR);
                for (int hour = start; hour < end; hour++) {
                    occupiedSlots[dayIndex][hour - OPENING_HOUR] = true;
                }
            }
        }

        int occupiedHours = 0;
        for (boolean[] daySlots : occupiedSlots) {
            for (boolean occupied : daySlots) {
                if (occupied) {
                    occupiedHours++;
                }
            }
        }
        return occupiedHours;
    }
}

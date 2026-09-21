public abstract class VisualizationComponent {
    protected static final String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu"};
    protected static final int OPENING_HOUR = 7;
    protected static final int CLOSING_HOUR = 17;
    protected static final int FIRST_HOUR = 8;
    protected static final int LAST_HOUR = 18;

    protected Activity[] activities;

    public VisualizationComponent() {
        this.activities = new Activity[0];
    }

    public void setActivities(Activity[] activities) {
        this.activities = activities;
        refresh();
    }

    public Activity[] getActivities() {
        return activities;
    }

    public abstract void refresh();
}

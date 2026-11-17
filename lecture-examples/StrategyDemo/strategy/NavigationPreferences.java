public final class NavigationPreferences {
    private final boolean avoidCongestion;
    private final boolean preferScenicRoutes;
    private final boolean avoidSteepInclines;
    private final boolean preferAccessibleRoutes;

    public NavigationPreferences(
            boolean avoidCongestion,
            boolean preferScenicRoutes,
            boolean avoidSteepInclines,
            boolean preferAccessibleRoutes) {
        this.avoidCongestion = avoidCongestion;
        this.preferScenicRoutes = preferScenicRoutes;
        this.avoidSteepInclines = avoidSteepInclines;
        this.preferAccessibleRoutes = preferAccessibleRoutes;
    }

    public boolean avoidsCongestion() {
        return avoidCongestion;
    }

    public boolean prefersScenicRoutes() {
        return preferScenicRoutes;
    }

    public boolean avoidsSteepInclines() {
        return avoidSteepInclines;
    }

    public boolean prefersAccessibleRoutes() {
        return preferAccessibleRoutes;
    }

    @Override
    public String toString() {
        return "avoid congestion: " + avoidCongestion
                + ", prefer scenic routes: " + preferScenicRoutes
                + ", avoid steep inclines: " + avoidSteepInclines
                + ", prefer accessible routes: " + preferAccessibleRoutes;
    }
}

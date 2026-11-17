public abstract class Navigator {
    private final Location currentLocation;
    private final NavigationPreferences preferences;

    protected Navigator(Location currentLocation, NavigationPreferences preferences) {
        this.currentLocation = currentLocation;
        this.preferences = preferences;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public NavigationPreferences getPreferences() {
        return preferences;
    }

    public abstract int calculateRoute(Location destination);
}

public class Navigator {
    private final Location currentLocation;
    private final NavigationPreferences preferences;
    private RouteStrategy routeStrategy;

    public Navigator(
            Location currentLocation,
            NavigationPreferences preferences,
            RouteStrategy routeStrategy) {
        this.currentLocation = currentLocation;
        this.preferences = preferences;
        this.routeStrategy = routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public int calculateRoute(Location destination) {
        return routeStrategy.calculateRoute(currentLocation, destination, preferences);
    }
}

public interface RouteStrategy {
    int calculateRoute(
            Location start,
            Location destination,
            NavigationPreferences preferences);
}

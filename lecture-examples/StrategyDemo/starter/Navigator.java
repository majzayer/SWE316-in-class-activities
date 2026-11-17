import java.util.concurrent.ThreadLocalRandom;

public class Navigator {
    private final Location currentLocation;
    private final NavigationPreferences preferences;

    public Navigator(Location currentLocation, NavigationPreferences preferences) {
        this.currentLocation = currentLocation;
        this.preferences = preferences;
    }

    public int calculateRoute(Location destination) {
        System.out.println("Calculating route from " + currentLocation.getName()
                + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(10, 61);
        System.out.println("Estimated travel time: " + minutes + " minutes");
        return minutes;
    }
}

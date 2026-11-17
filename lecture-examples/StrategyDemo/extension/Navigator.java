import java.util.concurrent.ThreadLocalRandom;

public class Navigator {
    private final Location currentLocation;
    private final NavigationPreferences preferences;

    public Navigator(Location currentLocation, NavigationPreferences preferences) {
        this.currentLocation = currentLocation;
        this.preferences = preferences;
    }

    public int calculateRoute(Location destination, TravelMode mode) {
        if (mode == TravelMode.DRIVING) {
            return calculateDrivingRoute(destination);
        } else if (mode == TravelMode.WALKING) {
            return calculateWalkingRoute(destination);
        }

        throw new IllegalArgumentException("Unsupported travel mode: " + mode);
    }

    private int calculateDrivingRoute(Location destination) {
        System.out.println("Calculating driving route from "
                + currentLocation.getName() + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(10, 31);
        System.out.println("Estimated driving time: " + minutes + " minutes");
        return minutes;
    }

    private int calculateWalkingRoute(Location destination) {
        System.out.println("Calculating walking route from "
                + currentLocation.getName() + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(31, 61);
        System.out.println("Estimated walking time: " + minutes + " minutes");
        return minutes;
    }
}

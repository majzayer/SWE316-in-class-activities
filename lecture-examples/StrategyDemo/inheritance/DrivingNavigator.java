import java.util.concurrent.ThreadLocalRandom;

public class DrivingNavigator extends Navigator {
    public DrivingNavigator(Location currentLocation, NavigationPreferences preferences) {
        super(currentLocation, preferences);
    }

    @Override
    public int calculateRoute(Location destination) {
        System.out.println("Calculating driving route from " + getCurrentLocation().getName()
                + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(10, 31);
        System.out.println("Estimated driving time: " + minutes + " minutes");
        return minutes;
    }
}

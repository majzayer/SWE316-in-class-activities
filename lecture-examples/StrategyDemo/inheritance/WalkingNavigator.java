import java.util.concurrent.ThreadLocalRandom;

public class WalkingNavigator extends Navigator {
    public WalkingNavigator(Location currentLocation, NavigationPreferences preferences) {
        super(currentLocation, preferences);
    }

    @Override
    public int calculateRoute(Location destination) {
        System.out.println("Calculating walking route from " + getCurrentLocation().getName()
                + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(31, 61);
        System.out.println("Estimated walking time: " + minutes + " minutes");
        return minutes;
    }
}

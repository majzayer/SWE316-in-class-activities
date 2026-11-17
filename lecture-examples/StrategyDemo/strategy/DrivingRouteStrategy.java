import java.util.concurrent.ThreadLocalRandom;

public class DrivingRouteStrategy implements RouteStrategy {
    @Override
    public int calculateRoute(
            Location start,
            Location destination,
            NavigationPreferences preferences) {
        System.out.println("Calculating driving route from " + start.getName()
                + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(10, 31);
        System.out.println("Estimated driving time: " + minutes + " minutes");
        return minutes;
    }
}

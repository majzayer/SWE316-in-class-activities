import java.util.concurrent.ThreadLocalRandom;

public class WalkingRouteStrategy implements RouteStrategy {
    @Override
    public int calculateRoute(
            Location start,
            Location destination,
            NavigationPreferences preferences) {
        System.out.println("Calculating walking route from " + start.getName()
                + " to " + destination.getName());
        int minutes = ThreadLocalRandom.current().nextInt(31, 61);
        System.out.println("Estimated walking time: " + minutes + " minutes");
        return minutes;
    }
}

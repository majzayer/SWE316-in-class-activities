public class Main {
    public static void main(String[] args) {
        Location campus = new Location("Campus");
        Location library = new Location("Library");
        Location park = new Location("Park");
        NavigationPreferences preferences = new NavigationPreferences(true, true, true, true);

        Navigator navigator = new DrivingNavigator(campus, preferences);
        System.out.println(navigator.calculateRoute(library));

        navigator = new WalkingNavigator(
                navigator.getCurrentLocation(),
                navigator.getPreferences());
        System.out.println(navigator.calculateRoute(park));
    }
}

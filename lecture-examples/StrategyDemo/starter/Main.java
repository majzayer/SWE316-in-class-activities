public class Main {
    public static void main(String[] args) {
        Location campus = new Location("Campus");
        Location library = new Location("Library");
        NavigationPreferences preferences = new NavigationPreferences(true, true, true, true);
        Navigator navigator = new Navigator(campus, preferences);

        System.out.println(navigator.calculateRoute(library));
    }
}

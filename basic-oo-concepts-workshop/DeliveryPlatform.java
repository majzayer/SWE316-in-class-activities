import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliveryPlatform {
    private String name;
    private List<Restaurant> restaurants = new ArrayList<>();

    public DeliveryPlatform(String name) {
        this.name = name;
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public String getName() {
        return name;
    }

    public List<Restaurant> getRestaurants() {
        return Collections.unmodifiableList(restaurants);
    }
}


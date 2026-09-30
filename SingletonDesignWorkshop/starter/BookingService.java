import java.util.HashSet;
import java.util.Set;

public class BookingService {
    private final Set<String> reservations = new HashSet<>();

    public boolean reserve(String room, String time) {
        String reservation = room + "-" + time;

        if (reservations.contains(reservation)) {
            return false;
        }

        reservations.add(reservation);
        return true;
    }

    public void cancel(String room, String time) {
        reservations.remove(room + "-" + time);
    }

    public int getReservationCount() {
        return reservations.size();
    }
}
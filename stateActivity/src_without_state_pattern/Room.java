import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final List<Booking> bookings = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public boolean isAvailable(
            Booking currentBooking,
            LocalDateTime proposedStart,
            LocalDateTime proposedEnd) {
        if (!proposedStart.isBefore(proposedEnd)) {
            return false;
        }

        return bookings.stream()
                .filter(booking -> booking != currentBooking)
                .noneMatch(booking -> overlaps(
                        proposedStart,
                        proposedEnd,
                        booking.getStartTime(),
                        booking.getEndTime()));
    }

    void reserve(Booking booking) {
        if (!isAvailable(booking, booking.getStartTime(), booking.getEndTime())) {
            throw new IllegalStateException("Room is not available for the booking");
        }
        bookings.add(booking);
    }

    void releaseReservation(Booking booking) {
        bookings.remove(booking);
    }

    void releaseRoom(Booking booking) {
        bookings.remove(booking);
    }

    public String getName() {
        return name;
    }

    private static boolean overlaps(
            LocalDateTime firstStart,
            LocalDateTime firstEnd,
            LocalDateTime secondStart,
            LocalDateTime secondEnd) {
        return firstStart.isBefore(secondEnd) && secondStart.isBefore(firstEnd);
    }
}

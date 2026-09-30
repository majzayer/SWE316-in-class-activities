public class BookingTerminal {
    private final String location;
    private final BookingService bookingManager;

    public BookingTerminal(String location) {
        this.location = location;
        this.bookingManager = new BookingService();
    }

    public void reserveRoom(String room, String time) {
        boolean successful = bookingManager.reserve(room, time);

        System.out.println(
            location + ": " +
            (successful ? "Reservation of room " + room + " at time " + time + " confirmed" : "Room unavailable")
        );
    }
}
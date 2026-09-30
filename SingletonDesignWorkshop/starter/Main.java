public class Main {
    public static void main(String[] args) {
        BookingTerminal libraryTerminal =
            new BookingTerminal("Library");

        BookingTerminal studentCenterTerminal =
            new BookingTerminal("Student Center");

        libraryTerminal.reserveRoom("Room 201", "10:00");
        studentCenterTerminal.reserveRoom("Room 201", "10:00");
    }
}

import java.time.LocalDateTime;

/**
 * Booking context without the State pattern.
 *
 * Each operation owns the state-specific logic and changes the status directly.
 */
public class Booking {
    private BookingStatus status;
    private final Student student;
    private final Room room;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public Booking(
            Student student,
            Room room,
            LocalDateTime startTime,
            LocalDateTime endTime) {
        this.student = student;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("startTime must be before endTime");
        }

        this.status = BookingStatus.RESERVED;
        room.reserve(this);
    }

    public void checkIn() {
        switch (status) {
            case RESERVED -> status = BookingStatus.IN_USE;
            case IN_USE -> throw new IllegalStateException("The booking is already in use");
            case COMPLETED -> throw new IllegalStateException("The booking is completed");
            case CANCELLED -> throw new IllegalStateException("The booking is cancelled");
        }
    }

    public void cancel() {
        switch (status) {
            case RESERVED -> {
                room.releaseReservation(this);
                status = BookingStatus.CANCELLED;
            }
            case IN_USE -> throw new IllegalStateException("An in-use booking cannot be cancelled");
            case COMPLETED -> throw new IllegalStateException("The booking is completed");
            case CANCELLED -> throw new IllegalStateException("The booking is already cancelled");
        }
    }

    public void changeEndTime(LocalDateTime newEnd) {
        switch (status) {
            case RESERVED -> {
                if (room.isAvailable(this, startTime, newEnd)) {
                    updateEndTime(newEnd);
                }
            }
            case IN_USE -> {
                if (newEnd.isAfter(endTime) && room.isAvailable(this, startTime, newEnd)) {
                    updateEndTime(newEnd);
                }
            }
            case COMPLETED -> throw new IllegalStateException("The booking is completed");
            case CANCELLED -> throw new IllegalStateException("The booking is cancelled");
        }
    }

    public void checkOut() {
        switch (status) {
            case RESERVED -> throw new IllegalStateException(
                    "A reserved booking must be checked in first");
            case IN_USE -> {
                room.releaseRoom(this);
                status = BookingStatus.COMPLETED;
            }
            case COMPLETED -> throw new IllegalStateException("The booking is completed");
            case CANCELLED -> throw new IllegalStateException("The booking is cancelled");
        }
    }

    private void updateEndTime(LocalDateTime newEnd) {
        if (!startTime.isBefore(newEnd)) {
            throw new IllegalArgumentException("endTime must be after startTime");
        }
        endTime = newEnd;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}

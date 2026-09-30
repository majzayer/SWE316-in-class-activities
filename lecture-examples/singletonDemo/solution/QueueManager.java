import java.util.Queue;

public class QueueManager {
    private static QueueManager INSTANCE;

    private int nextNumber;
    private Queue<Ticket> waiting;

    private QueueManager() {
        this.nextNumber = 1;
        this.waiting = new java.util.LinkedList<>();
    }

    public static QueueManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new QueueManager();
        }
        return INSTANCE;
    }

    public void checkIn(String customerName) {
        Ticket ticket = new Ticket(nextNumber++, customerName);
        waiting.add(ticket);

        System.out.println(
            "Printed ticket " + ticket.number()
            + " for " + ticket.customerName()
        );
    }

    public Ticket callNext() {
        Ticket ticket = waiting.remove();

        System.out.println(
            "Display: Now serving " + ticket.number()
        );

        return ticket;
    }

    public int getNumberWaiting() {
        return waiting.size();
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private int nextNumber;
    private Queue<Ticket> waiting;

    public QueueManager() {
        this.nextNumber = 1;
        this.waiting = new LinkedList<>();
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

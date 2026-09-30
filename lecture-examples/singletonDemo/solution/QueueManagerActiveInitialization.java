import java.util.Queue;

public class QueueManagerActiveInitialization {
    private static final QueueManagerActiveInitialization INSTANCE = new QueueManagerActiveInitialization();

    private int nextNumber;
    private Queue<Ticket> waiting;

    private QueueManagerActiveInitialization() {
        this.nextNumber = 1;
        this.waiting = new java.util.LinkedList<>();
    }

    public static QueueManagerActiveInitialization getInstance() {
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

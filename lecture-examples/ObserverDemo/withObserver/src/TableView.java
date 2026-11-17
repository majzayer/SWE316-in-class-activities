public class TableView implements Observer {
    private final PollData poll;

    public TableView(PollData poll) {
        this.poll = poll;
    }

    @Override
    public void update() {
        showRows(poll.getA(), poll.getB(), poll.getC());
    }

    public void showRows(int a, int b, int c) {
        System.out.println("TableView:");
        System.out.println("A = " + a + " | B = " + b + " | C = " + c);
    }
}

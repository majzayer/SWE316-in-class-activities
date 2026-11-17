public class BarChartView implements Observer {
    private final PollData poll;

    public BarChartView(PollData poll) {
        this.poll = poll;
    }

    @Override
    public void update() {
        drawBars(poll.getA(), poll.getB(), poll.getC());
    }

    public void drawBars(int a, int b, int c) {
        System.out.println("BarChartView:");
        System.out.println("A: " + "#".repeat(a / 10));
        System.out.println("B: " + "#".repeat(b / 10));
        System.out.println("C: " + "#".repeat(c / 10));
    }
}

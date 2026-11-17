import javax.swing.Timer;

public class PollApp {
    private final PollData poll = new PollData();
    private final TableView table = new TableView();
    private final BarChartView bars = new BarChartView();
    private final PieChartView pie = new PieChartView();
    private final Timer timer = new Timer(1000, event -> refreshViews());

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    private void refreshViews() {
        int a = poll.getA();
        int b = poll.getB();
        int c = poll.getC();

        table.showRows(a, b, c);
        bars.drawBars(a, b, c);
        pie.drawSlices(a, b, c);
    }
}

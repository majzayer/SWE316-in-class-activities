public class PollData {
    private int a;
    private int b;
    private int c;

    private final TableView table;
    private final BarChartView bars;
    private final PieChartView pie;

    public PollData(TableView table, BarChartView bars, PieChartView pie) {
        this.table = table;
        this.bars = bars;
        this.pie = pie;
    }

    public void setVotes(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

        table.showRows(a, b, c);
        bars.drawBars(a, b, c);
        pie.drawSlices(a, b, c);
    }
}

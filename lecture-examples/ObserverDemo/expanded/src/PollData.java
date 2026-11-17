public class PollData {
    private int a;
    private int b;
    private int c;

    private final TableView table;
    private final BarChartView bars;
    private final PieChartView pie;
    private final LineChartView lineChart;

    public PollData(TableView table, BarChartView bars, PieChartView pie, LineChartView lineChart) {
        this.table = table;
        this.bars = bars;
        this.pie = pie;
        this.lineChart = lineChart;
    }

    public void setVotes(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

        table.showRows(a, b, c);
        bars.drawBars(a, b, c);
        pie.drawSlices(a, b, c);
        lineChart.drawLine(a, b, c);
    }
}

public class Demo {
    public static void main(String[] args) {
        TableView table = new TableView();
        BarChartView bars = new BarChartView();
        PieChartView pie = new PieChartView();
        LineChartView lineChart = new LineChartView();

        PollData pollData = new PollData(table, bars, pie, lineChart);

        System.out.println("Initial design with a new LineChartView.");
        pollData.setVotes(50, 30, 20);
        System.out.println("-----------------------------------");
        pollData.setVotes(10, 60, 30);
    }
}

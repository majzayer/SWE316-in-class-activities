public class Demo {
    public static void main(String[] args) {
        TableView table = new TableView();
        BarChartView bars = new BarChartView();
        PieChartView pie = new PieChartView();

        PollData pollData = new PollData(table, bars, pie);

        System.out.println("Initial design: PollData directly calls each view.");
        pollData.setVotes(50, 30, 20);
        System.out.println("-----------------------------------");
        pollData.setVotes(10, 60, 30);
    }
}

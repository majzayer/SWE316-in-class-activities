public class Main {
    public static void main(String[] args) {
        PollData poll = new PollData();
        TableView table = new TableView(poll);
        BarChartView bars = new BarChartView(poll);
        PieChartView pie = new PieChartView(poll);

        poll.addObserver(table);
        poll.addObserver(bars);
        poll.addObserver(pie);

        poll.setVotes(50, 30, 20);
    }
}

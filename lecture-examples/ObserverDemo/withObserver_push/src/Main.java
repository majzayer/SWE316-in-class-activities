public class Main {
    public static void main(String[] args) {
        PollData poll = new PollData();
        TableView table = new TableView();
        BarChartView bars = new BarChartView();
        PieChartView pie = new PieChartView();

        poll.addObserver(table);
        poll.addObserver(bars);
        poll.addObserver(pie);

        poll.setVotes(50, 30, 20);
    }
}

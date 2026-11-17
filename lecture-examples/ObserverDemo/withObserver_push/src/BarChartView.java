public class BarChartView implements Observer {
    @Override
    public void update(int a, int b, int c) {
        drawBars(a, b, c);
    }

    public void drawBars(int a, int b, int c) {
        System.out.println("BarChartView:");
        System.out.println("A: " + "#".repeat(a / 10));
        System.out.println("B: " + "#".repeat(b / 10));
        System.out.println("C: " + "#".repeat(c / 10));
    }
}

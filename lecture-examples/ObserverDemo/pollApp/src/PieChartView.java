public class PieChartView {
    public void drawSlices(int a, int b, int c) {
        int total = a + b + c;
        System.out.println("PieChartView:");
        System.out.println("A slice = " + ((total == 0) ? 0 : (a * 100 / total)) + "%");
        System.out.println("B slice = " + ((total == 0) ? 0 : (b * 100 / total)) + "%");
        System.out.println("C slice = " + ((total == 0) ? 0 : (c * 100 / total)) + "%");
    }
}

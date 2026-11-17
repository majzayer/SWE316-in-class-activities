public class TableView implements Observer {
    @Override
    public void update(int a, int b, int c) {
        showRows(a, b, c);
    }

    public void showRows(int a, int b, int c) {
        System.out.println("TableView:");
        System.out.println("A = " + a + " | B = " + b + " | C = " + c);
    }
}

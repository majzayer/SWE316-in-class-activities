public class PollData extends Subject {
    private int a = 50;
    private int b = 30;
    private int c = 20;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public void setVotes(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        notifyObservers(a, b, c);
    }
}

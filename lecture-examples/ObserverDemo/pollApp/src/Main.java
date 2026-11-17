import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        PollApp pollApp = new PollApp();
        pollApp.start();

        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            pollApp.stop();
        }
    }
}


public class TwoThreadSingletonDemo {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                QueueManagerActiveInitialization instance = QueueManagerActiveInitialization.getInstance();
                System.out.println(
                    "Thread: " + threadName
                    + " got instance hash = " + System.identityHashCode(instance)
                    + " with queue size = " + instance.getNumberWaiting()
                );
                
                String customerId = getRandomID();
                instance.checkIn(customerId);

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(task, "Reception");
        Thread t2 = new Thread(task, "MobileApp");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static String getRandomID() {
        return "Customer-" + (int) (Math.random() * 1000);
    }
}

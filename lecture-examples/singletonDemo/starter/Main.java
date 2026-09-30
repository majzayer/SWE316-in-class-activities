public class Main {
    public static void main(String[] args) {

        QueueManager receptionQueueManager = new QueueManager();
        receptionQueueManager.checkIn("Mohammad");
        
        // at a different system, a different queue manager is created
        QueueManager kioskQueueManager = new QueueManager();
        kioskQueueManager.checkIn("Abdullah");


    }
}

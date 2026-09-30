public class Main {
    public static void main(String[] args) {
        QueueManager receptionQueueManager = QueueManager.getInstance();
        QueueManager kioskQueueManager = QueueManager.getInstance();
        
        receptionQueueManager.checkIn("Mohammad");
        kioskQueueManager.checkIn("Abdullah");

    }
}

// A single notification class handling all types of notifications
class Notification {
    String type;
    String recipient;
    String message;
    
    public Notification(String type, String recipient, String message) {
        this.type = type;
        this.recipient = recipient;
        this.message = message;
    }

    public void sendEmail() {
        System.out.println("Sending EMAIL to " + recipient + ": " + message);
    }

    public void sendSMS() {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }

    public void sendPushNotification() {
        System.out.println("Sending PUSH notification to " + recipient + ": " + message);
    }

    public void sendNotification() {
        if (type.equals("EMAIL")) {
            sendEmail();
        } else if (type.equals("SMS")) {
            sendSMS();
        } else if (type.equals("PUSH")) {
            sendPushNotification();
        }
    }
}

// NotificationService responsible for sending notifications
class NotificationService {
    public void notifyUsers(List<Notification> notifications) {
        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Notification> notifications = Arrays.asList(
            new Notification("EMAIL", "john@example.com", "You have a new message!"),
            new Notification("SMS", "555-1234", "Your package has been shipped."),
            new Notification("PUSH", "user123", "Your balance is low.")
        );
        
        NotificationService notificationService = new NotificationService();
        notificationService.notifyUsers(notifications);
    }
}

interface NotificationChannel {
    void send(String recipient, String message);
}

/*
* Each of these notification services is a functionally cohesive
* unit, focused only on one purpose, which makes it easier to reuse
* in other contexts.
*/
class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending EMAIL to " + recipient + ": " + message);
    }
}

class SMSNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

class PushNotificationChannel implements NotificationChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending PUSH notification to " + recipient + ": " + message);
    }
}

/*
* Summary of refactoring benefits:
* - Increasing cohesion focused the class on managing notification
* data, resulting in increased reusability in other contexts
* - reducing control coupling and abstraction, generalized the 
* the code of this class, which also contributes to better
* reusability, flexibility, and maintainability.
*/
class Notification {
    /*
    * Mitigate the risk of content coupling by locking
    * access to the instance variables of notification
    */
    private String recipient;
    
    private String message;

    /*
    * Increase the cohesion of the notification class
    * by making it focused only on managing the notification
    * data without worrying about how notifications are sent
    * and what channels are supported.
    * 
    * Factoring out the conditional logic allowed for 
    * eliminating control coupling.
    */
    private NotificationChannel channel;

    public Notification(String recipient, String message, NotificationChannel channel) {
        this.recipient = recipient;
        this.message = message;
        this.channel = channel;
    }

    /*
    * Introducing the wrapper of the channel further reduces
    * chances of control coupling. The class claims control
    * of the rules of sending a notification. In the future,
    * we can add a consistenet logging mechanism or retry
    * mechanism.
    */
    public void sendNotification() {
        channel.send(recipient, message);
    }
}

class NotificationService {
    public void notifyUsers(List<Notification> notifications) {
        for (Notification notification : notifications) {
            notification.sendNotification();
        }
    }
}

class NottificationManagementExampleSolution {
  public static void main(String[] args) {
      NotificationChannel emailChannel = new EmailNotificationChannel();
      NotificationChannel smsChannel = new SMSNotificationChannel();
      NotificationChannel pushChannel = new PushNotificationChannel();
      NotificationChannel slackChannel = new SlackNotificationChannel();

      List<Notification> notifications = Arrays.asList(
          new Notification("john@example.com", "You have a new message!", emailChannel),
          new Notification("555-1234", "Your package has been shipped.", smsChannel),
          new Notification("user123", "Your balance is low.", pushChannel),
          new Notification("@slack_user", "Team meeting at 3 PM.", slackChannel)
      );
        
      NotificationService notificationService = new NotificationService();
      notificationService.notifyUsers(notifications);
    }
}

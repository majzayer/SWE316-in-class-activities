public class Emailer {
    public void sendEmail(Addressee addressee, String text) {
        System.out.println("Sending email to " + addressee.getName()
                + " at " + addressee.getEmail() + ": " + text);
    }
}

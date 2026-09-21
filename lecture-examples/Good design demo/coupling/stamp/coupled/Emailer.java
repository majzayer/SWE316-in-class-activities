/*
 * Stamp coupling example
 * Emailer depends on the complete Employee type even though it only needs
 * the employee's name and email address.
 */
public class Emailer {
    public void sendEmail(Employee employee, String text) {
        System.out.println("Sending email to " + employee.getName()
                + " at " + employee.getEmail() + ": " + text);
    }
}

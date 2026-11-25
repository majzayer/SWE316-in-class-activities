// The registrar requires every approved request to be logged.
public class AuditLog {
    public static void record(String requestType, String studentId) {
        System.out.println("  [AUDIT] " + requestType + " approved for " + studentId);
    }
}

/**
 * The registrar requires every grade import to be logged.
 */
public class AuditLog {
    public static void record(String source, int imported, int rejected) {
        System.out.println("[AUDIT] " + source + ": " + imported + " imported, "
                + rejected + " rejected");
    }
}

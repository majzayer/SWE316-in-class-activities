/*
 * Control coupling example
 * Depending on the value of the flag, a certain method is called.
 */
public class ReportGenerator {
    public void generateReport(boolean isDetailed) {
        if (isDetailed) {
            generateDetailedReport();
        } else {
            generateSummaryReport();
        }
    }

    private void generateDetailedReport() {
        System.out.println("Generating detailed report...");
        // Detailed report logic
    }

    private void generateSummaryReport() {
        System.out.println("Generating summary report...");
        // Summary report logic
    }
}

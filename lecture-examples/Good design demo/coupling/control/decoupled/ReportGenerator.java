/*
 * Control (de-)coupling example
 */
public class ReportGenerator {
    private Reportable report;

    public ReportGenerator(Reportable report) {
        this.report = report;
    }

    public void generateReport() {
        report.generate();
    }
}

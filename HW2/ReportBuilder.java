public class ReportBuilder {

    public String buildReport(Employee employee) {
        StringBuilder report = new StringBuilder();
        
        // Add header, main content, and footer
        report.append(addReportHeader());
        report.append(createMainReportContent(employee));
        report.append(addReportFooter());
        
        return report.toString();
    }

    public String addReportHeader() {
        return "=== Report Header ===\n";
    }

    public String createMainReportContent(Employee employee) {
        MainReportContent contentProvider = new MainReportContent();
        return contentProvider.makeMainReportContent(employee);
    }

    public String addReportFooter() {
        return "\n=== Report Footer ===";
    }
}

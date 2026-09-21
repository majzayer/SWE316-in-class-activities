public class MainReportContent {
    public String makeMainReportContent(Employee employee) {
        // Default implementation: Only includes the employee's name
        return "Employee Report\n" +
               "Name: " + employee.getName() + "\n";
    }
}

public class EmployeeDataViewer {
    public String reportHours(Employee employee) {
        return employee.getName() + " worked " + employee.getHoursWorked() + " hours.";
    }

    public String reportEmployee(Employee employee) {
        return employee.getId() + " - " + employee.getName() + " - " + employee.getHourlyRate();
    }

    public String reportPay(Employee employee, double pay) {
        return employee.getName() + " earned " + pay;
    }
}
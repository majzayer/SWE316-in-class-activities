public class EmployeePayService {
    public double calculatePay(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("employee cannot be null");
        }
        return employee.getHourlyRate() * employee.getHoursWorked();
    }

    public double calculateWeeklyPay(Employee employee) {
        return calculatePay(employee) * 5;
    }

    public double calculateOvertimePay(Employee employee, int overtimeHours) {
        return employee.getHourlyRate() * overtimeHours * 1.5;
    }
}
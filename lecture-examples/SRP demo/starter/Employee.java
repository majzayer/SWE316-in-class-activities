import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Employee {
    private static final Map<String, Employee> SAVED_EMPLOYEES = new LinkedHashMap<>();

    private final String id;
    private final String name;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    public void recordHours(int hours) {
        hoursWorked += hours;
    }

    public void changeHourlyRate(double newRate) {
        hourlyRate = newRate;
    }

    public boolean hasWorkedHours() {
        return hoursWorked > 0;
    }

    public String reportHours() {
        return name + " worked " + hoursWorked + " hours.";
    }

    public void save() {
        SAVED_EMPLOYEES.put(id, this);
    }

    public void delete(String employeeId) {
        SAVED_EMPLOYEES.remove(employeeId);
    }

    public boolean exists(String employeeId) {
        return SAVED_EMPLOYEES.containsKey(employeeId);
    }

    public int count() {
        return SAVED_EMPLOYEES.size();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("hourlyRate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("hoursWorked cannot be negative");
        }
        this.hoursWorked = hoursWorked;
    }

    public double calculateWeeklyPay() {
        return calculatePay() * 5;
    }

    public double calculateOvertimePay(int overtimeHours) {
        return hourlyRate * overtimeHours * 1.5;
    }

    public String reportEmployee() {
        return id + " - " + name + " - " + hourlyRate;
    }

    public String reportPay(double pay) {
        return name + " earned " + pay;
    }

    public static Map<String, Employee> savedEmployees() {
        return Collections.unmodifiableMap(SAVED_EMPLOYEES);
    }

}

public class Employee {
    private final String id;
    private final String name;
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
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
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
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
}
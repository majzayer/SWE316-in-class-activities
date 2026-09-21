public class Employee {
    private String employeeId;
    private String name;
    private String email;
    private String department;
    private String jobTitle;

    public Employee(
            String employeeId,
            String name,
            String email,
            String department,
            String jobTitle) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

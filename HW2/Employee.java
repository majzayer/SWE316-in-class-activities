public class Employee {
    private String name;
    private String jobTitle;
    private double salary;
    private int yearsOfExperience;

    public Employee(String name, String jobTitle, double salary, int yearsOfExperience) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}

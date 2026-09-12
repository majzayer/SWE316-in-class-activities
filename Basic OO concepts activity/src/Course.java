public class Course {
    private int number;
    private String name;
    private String instructor;
    private String department;

    public Course(int number, String name, String instructor, String department) {
        this.number = number;
        this.name = name;
        this.instructor = instructor;
        this.department = department;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

package cohesion.layer.threeLayer.data;

import java.util.ArrayList;
import java.util.List;

/** Data object shared by the business operations. */
public class StudentRecord {
    private final String studentId;
    private final String studentName;
    private final List<String> completedCourses;
    private final List<String> registeredClasses = new ArrayList<>();

    public StudentRecord(String studentId, String studentName,
            List<String> completedCourses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.completedCourses = new ArrayList<>(completedCourses);
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getCompletedCourses() {
        return List.copyOf(completedCourses);
    }

    public List<String> getRegisteredClasses() {
        return List.copyOf(registeredClasses);
    }

    public void registerFor(String className) {
        addCourse(className);
    }

    public void addCourse(String course) {
        registeredClasses.add(course);
    }

    public void removeCourse(String course) {
        registeredClasses.remove(course);
    }
}

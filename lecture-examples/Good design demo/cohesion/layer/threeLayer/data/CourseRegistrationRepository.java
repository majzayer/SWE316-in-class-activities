package cohesion.layer.threeLayer.data;

/** Data-layer contract for storing course registrations. */
public interface CourseRegistrationRepository {
    StudentRecord findStudent(String studentId);

    void addCourse(StudentRecord student, String course);

    void removeCourse(StudentRecord student, String course);
}

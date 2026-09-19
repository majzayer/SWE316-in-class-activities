package cohesion.layer.threeLayer.data;

/** Database-backed course registration implementation for demonstration purposes. */
public class DatabaseCourseRegistrationRepository implements CourseRegistrationRepository {
    private final StudentRepository studentRepository;

    public DatabaseCourseRegistrationRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentRecord findStudent(String studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void addCourse(StudentRecord student, String course) {
        student.addCourse(course);
    }

    @Override
    public void removeCourse(StudentRecord student, String course) {
        student.removeCourse(course);
    }
}
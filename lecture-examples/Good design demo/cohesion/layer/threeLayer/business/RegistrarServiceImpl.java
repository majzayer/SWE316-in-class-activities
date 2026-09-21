package cohesion.layer.threeLayer.business;

import cohesion.layer.threeLayer.data.CourseRegistrationRepository;
import cohesion.layer.threeLayer.data.StudentRecord;

/** Business implementation for course registration operations. */
public class RegistrarServiceImpl implements RegistrarService {
    private final CourseRegistrationRepository repository;

    public RegistrarServiceImpl(CourseRegistrationRepository repository) {
        this.repository = repository;
    }

    @Override
    public String addCourse(String studentId, String course) {
        StudentRecord student = findStudent(studentId);
        repository.addCourse(student, course);
        return student.getStudentName() + " added " + course;
    }

    @Override
    public String removeCourse(String studentId, String course) {
        StudentRecord student = findStudent(studentId);
        repository.removeCourse(student, course);
        return student.getStudentName() + " removed " + course;
    }

    private StudentRecord findStudent(String studentId) {
        StudentRecord student = repository.findStudent(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        return student;
    }
}
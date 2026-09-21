package cohesion.layer.threeLayer.business;

import cohesion.layer.threeLayer.data.StudentRecord;
import cohesion.layer.threeLayer.data.StudentRepository;

/** Business implementation for academic operations. */
public class AcademicServiceImpl implements AcademicService {
    private final StudentRepository repository;

    public AcademicServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String showTranscript(String studentId) {
        StudentRecord record = findStudent(studentId);
        return record.getStudentName() + " completed: "
                + String.join(", ", record.getCompletedCourses());
    }

    @Override
    public String registerForClass(String studentId, String className) {
        StudentRecord record = findStudent(studentId);
        record.registerFor(className);
        return record.getStudentName() + " registered for " + className;
    }

    private StudentRecord findStudent(String studentId) {
        StudentRecord record = repository.findById(studentId);
        if (record == null) {
            throw new IllegalArgumentException("Student not found: " + studentId);
        }
        return record;
    }
}
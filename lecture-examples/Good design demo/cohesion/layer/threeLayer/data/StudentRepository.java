package cohesion.layer.threeLayer.data;

/** Data-layer contract for storing and retrieving student records. */
public interface StudentRepository {
    void save(StudentRecord record);

    StudentRecord findById(String studentId);
}
